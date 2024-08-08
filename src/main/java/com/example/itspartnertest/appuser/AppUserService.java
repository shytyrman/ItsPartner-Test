package com.example.itspartnertest.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

import java.util.function.Consumer;

@Service
@AllArgsConstructor
public class AppUserService implements ReactiveUserDetailsService{

    private static final String USER_NOT_FOUND_MESSAGE = "user with username %s not found!";
    private final AppUserRepository userRepository;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository.findBasicUserByLogin(username);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return new AppUser((BasicUser) userRepository.findBasicUserByLogin(username).subscribe());
//    }

}
