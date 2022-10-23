package com.registerapp.registerServerAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserRegistrationDto {
    private String name;
    private String surname;
    private String email;
    private String password;
}
