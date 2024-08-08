package com.example.itspartnertest.service.location;

import com.example.itspartnertest.appuser.AppUser;
import com.example.itspartnertest.model.Location;
import com.example.itspartnertest.model.dto.CreateLocationRequest;
import reactor.core.publisher.Flux;

public interface LocationService {
    public Location create(AppUser appUser, CreateLocationRequest createLocationRequest);

    Flux<Location> getUserLocationList(Long userId);

    Flux<Location> getAllLocations();
}
