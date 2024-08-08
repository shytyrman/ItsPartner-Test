package com.example.itspartnertest.service.registration;

import com.example.itspartnertest.appuser.AppUser;
import com.example.itspartnertest.model.dto.RegistrationRequest;

public interface RegistrationService {
    public AppUser register(AppUser appUser, RegistrationRequest registrationRequest);
}
