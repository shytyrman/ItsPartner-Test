package com.example.itspartnertest.repository;

import com.example.itspartnertest.model.UserLocation;
import com.example.itspartnertest.model.enums.UserLocationPermission;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserLocationRepository extends ReactiveCrudRepository<UserLocation, Long> {
    public Flux<UserLocation> findAllByUserId(Long id);
    public Mono<UserLocation> findByUserId(Long id);
    public Mono<Boolean> existsByUserIdAndLocationId(Long userId, Long locationId);
    @Query("UPDATE USER_LOCATION SET PUBLIC.USER_LOCATION.PERMISSION = :permission WHERE USER_ID = :userId AND LOCATION_ID = :locationId")
    public Mono<UserLocation> updatePermission(@Param("userId") Long userId, @Param("locationId") Long locationId, @Param("permission") UserLocationPermission permission);
    @Query("SELECT * FROM USER_LOCATION WHERE LOCATION_ID = :locationId")
    public Flux<UserLocation> findByLocationId(@Param("locationId") Long locationId);
}
