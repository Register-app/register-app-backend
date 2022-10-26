package com.registerapp.registerServerAPI.payload;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {
    private String userEmail;
    private String userPassword;
}
