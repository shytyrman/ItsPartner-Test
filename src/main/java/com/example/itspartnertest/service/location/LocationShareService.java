package com.example.itspartnertest.service.location;

import com.example.itspartnertest.appuser.AppUser;
import com.example.itspartnertest.model.dto.ShareLocationRequest;

public interface LocationShareService {
    void share(AppUser appUser, ShareLocationRequest request);
}
