package com.example.itspartnertest.model;

import com.example.itspartnertest.model.enums.UserLocationPermission;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
public class UserLocation {

    @Id
    private Long id;
    @Column(value = "user_id")
    private Long userId;
    @Column(value = "location_id")
    private Long locationId;
    private UserLocationPermission permission;
}
