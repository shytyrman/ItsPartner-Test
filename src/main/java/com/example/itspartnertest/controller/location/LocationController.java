package com.example.itspartnertest.controller.location;

import com.example.itspartnertest.appuser.AppUser;
import com.example.itspartnertest.appuser.AppUserRepository;
import com.example.itspartnertest.model.Location;
import com.example.itspartnertest.model.dto.CreateLocationRequest;
import com.example.itspartnertest.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/location")
@RequiredArgsConstructor
public class LocationController {

    private final AppUserRepository appUserRepository;
    private final LocationService locationService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> createLocation(@AuthenticationPrincipal AppUser appUser, @RequestBody CreateLocationRequest request) {
        Location location = locationService.create(appUser, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(location);
    }

    @GetMapping(path = "/all")
    public Flux<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping(path = "/my")
    public Flux<Location> getAllMyLocations(@AuthenticationPrincipal AppUser appUser) {
        return locationService.getUserLocationList(appUser.getId());
    }

    @GetMapping(path = "/{user_id}")
    public Flux<Location> getAllUserLocations(@PathVariable(value = "user_id") Long user_id) {
        return locationService.getUserLocationList(user_id);
    }

    @GetMapping(path = "/users/{locationId}")
    public Flux<AppUser> getAllUsersWithLocation(@PathVariable(value = "locationId") Long locationId) {
        return locationService.getUsersWithLocation(locationId);
    }
}
