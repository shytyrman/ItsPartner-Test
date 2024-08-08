package com.example.itspartnertest.model.dto;

import com.example.itspartnertest.model.enums.UserLocationPermission;
import lombok.Data;

@Data
public class ShareLocationRequest {

    private Long targetUserId;
    private Long shareLocationId;
    private UserLocationPermission permission;
}
