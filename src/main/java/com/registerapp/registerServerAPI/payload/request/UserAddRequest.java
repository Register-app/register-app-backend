package com.registerapp.registerServerAPI.payload.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
public class UserAddRequest {
    private String name;
    private String second_name;
    private String email;
    private String password;
}
