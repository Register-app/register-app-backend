package com.registerapp.registerServerAPI.payload.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
public class UserRegistrationRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String second_name;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
