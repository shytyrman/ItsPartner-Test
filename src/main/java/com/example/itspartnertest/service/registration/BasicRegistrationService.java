package com.example.itspartnertest.service.registration;

import com.example.itspartnertest.appuser.AppUser;
import com.example.itspartnertest.appuser.AppUserRepository;
import com.example.itspartnertest.appuser.AppUserRole;
import com.example.itspartnertest.model.dto.RegistrationRequest;
import com.example.itspartnertest.service.mapper.RegistrationRequestToAppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BasicRegistrationService implements RegistrationService{

    private final RegistrationRequestToAppUser mapper;
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AppUser register(AppUser appUser, RegistrationRequest registrationRequest) {
        mapper.map(registrationRequest, appUser);

        appUser.setUserRole(AppUserRole.USER);

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser).subscribe();

        return appUser;
    }
}
