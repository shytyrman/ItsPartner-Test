package com.example.itspartnertest.service.location;

import com.example.itspartnertest.appuser.AppUser;
import com.example.itspartnertest.model.Location;
import com.example.itspartnertest.model.UserLocation;
import com.example.itspartnertest.model.dto.CreateLocationRequest;
import com.example.itspartnertest.repository.LocationRepository;
import com.example.itspartnertest.repository.UserLocationRepository;
import com.example.itspartnertest.service.location.mapper.CreateLocationRequestToLocation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class BasicLocationService implements LocationService{

    private final CreateLocationRequestToLocation mapper;
    private final LocationRepository locationRepository;
    private final UserLocationRepository userLocationRepository;
    @Override
    public Location create(AppUser appUser, CreateLocationRequest createLocationRequest) {
        Location location = new Location();
        mapper.map(createLocationRequest, location);

        locationRepository.save(location).subscribe();

        UserLocation userLocation = new UserLocation();
        userLocation.setUserId(appUser.getId());
        userLocation.setLocationId(location.getId());

        userLocationRepository.save(userLocation).subscribe();
        return location;
    }

    @Override
    public Flux<Location> getUserLocationList(Long userId) {
        Flux<UserLocation> userLocationFlux = userLocationRepository.findAllByUserId(userId);

        Flux<Location> locationFlux = userLocationFlux.flatMap(userLocation -> {
            return locationRepository.findById(userLocation.getLocationId());
        });

        return locationFlux;
    }

    public Flux<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
