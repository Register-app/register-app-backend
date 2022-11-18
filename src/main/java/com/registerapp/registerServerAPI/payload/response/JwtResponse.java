package com.registerapp.registerServerAPI.payload.response;

import com.registerapp.registerServerAPI.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Data
public class JwtResponse {
    private Long user_id;
    private String name;
    private String second_name;
    private String email;
    private String jwtToken;
}
