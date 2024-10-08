package com.example.itspartnertest.controller.registration;

import com.example.itspartnertest.appuser.AppUser;
import com.example.itspartnertest.appuser.AppUserRepository;
import com.example.itspartnertest.model.dto.RegistrationRequest;
import com.example.itspartnertest.service.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    private final AppUserRepository appUserRepository;
    @PostMapping
    @Transactional
    public Mono<ResponseEntity<?>> register(@RequestBody RegistrationRequest registrationRequest) {

        AppUser appUser = new AppUser();

        if (!registrationRequest.getPassword().equals(registrationRequest.getCheckPassword())) {
            throw new IllegalStateException("Given passwords are different, try again!");
        }

        registrationService.register(appUser, registrationRequest);

        return Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(appUser));
    }

    @GetMapping(path = "/me")
    public Mono<ResponseEntity<?>> getMe(@AuthenticationPrincipal AppUser appUser) {
        return Mono.just(ResponseEntity.status(HttpStatus.ACCEPTED).body(appUser));
    }

    @GetMapping(path = "/all")
    public Flux<AppUser> getAll() {
        return appUserRepository.findAll();
    }
}

