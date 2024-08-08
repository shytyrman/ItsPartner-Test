package com.example.itspartnertest.service.location;

import com.example.itspartnertest.appuser.AppUser;
import com.example.itspartnertest.model.UserLocation;
import com.example.itspartnertest.model.dto.ShareLocationRequest;
import com.example.itspartnertest.model.enums.UserLocationPermission;
import com.example.itspartnertest.repository.UserLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class BasicLocationShareService implements LocationShareService{

    private final UserLocationRepository userLocationRepository;
    public void share(AppUser appUser, ShareLocationRequest request) {

        UserLocation userLocation = new UserLocation();
        userLocation.setUserId(request.getTargetUserId());
        userLocation.setLocationId(request.getShareLocationId());
        userLocation.setPermission(request.getPermission());

        userLocationRepository.save(userLocation).subscribe();
    }

}
