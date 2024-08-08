package com.example.itspartnertest.service.location.mapper;

import com.example.itspartnertest.model.Location;
import com.example.itspartnertest.model.dto.CreateLocationRequest;
import org.springframework.stereotype.Service;

@Service
public class CreateLocationRequestToLocation {
    public void map(CreateLocationRequest createLocationRequest, Location location) {
        location.setName(createLocationRequest.getName());
        location.setAddress(createLocationRequest.getAddress());
    }
}
