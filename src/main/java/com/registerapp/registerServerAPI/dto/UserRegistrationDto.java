package com.registerapp.registerServerAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserRegistrationDto {
    private String name;
    private String second_name;
    private String email;
    private String password;
}
