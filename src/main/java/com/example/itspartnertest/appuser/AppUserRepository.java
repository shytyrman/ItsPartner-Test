package com.example.itspartnertest.appuser;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;

public interface AppUserRepository extends ReactiveCrudRepository<AppUser, Integer> {
//    public Optional<BasicUser> findBasicUserByLogin(String login);
    public Mono<UserDetails> findBasicUserByLogin(String login);
//    public Boolean existsBasicUserByLogin(String login);
}
