package com.example.itspartnertest.repository;

import com.example.itspartnertest.model.Location;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface LocationRepository extends ReactiveCrudRepository<Location, Long> {
}
