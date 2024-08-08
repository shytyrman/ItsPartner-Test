package com.example.itspartnertest.controller.location;

import com.example.itspartnertest.appuser.AppUser;
import com.example.itspartnertest.model.dto.ShareLocationRequest;
import com.example.itspartnertest.service.location.LocationShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location/share")
@RequiredArgsConstructor
public class LocationShareController {

    private final LocationShareService locationShareService;
    @PostMapping
    public void share(@AuthenticationPrincipal AppUser appUser, @RequestBody ShareLocationRequest request) {
        locationShareService.share(appUser, request);
    }
}
