package com.example.itspartnertest.model.dto;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String login;
    private String password;
    private String checkPassword;
    private String name;
    private String surname;
    private String email;
}
