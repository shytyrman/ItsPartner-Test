package com.example.itspartnertest.service.registration.mapper;

import com.example.itspartnertest.appuser.AppUser;
import com.example.itspartnertest.model.dto.RegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class RegistrationRequestToAppUser {

    public AppUser map(RegistrationRequest registrationRequest, AppUser appUser) {
        appUser.setLogin(registrationRequest.getLogin());
        appUser.setPassword(registrationRequest.getPassword());
        appUser.setName(registrationRequest.getName());
        appUser.setSurname(registrationRequest.getSurname());
        appUser.setEmail(registrationRequest.getEmail());

        return appUser;
    }
}
