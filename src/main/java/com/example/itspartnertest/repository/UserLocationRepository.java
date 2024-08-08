package com.example.itspartnertest.repository;

import com.example.itspartnertest.model.Location;
import com.example.itspartnertest.model.UserLocation;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserLocationRepository extends ReactiveCrudRepository<UserLocation, Long> {
    public Flux<UserLocation> findAllByUserId(Long id);
}
