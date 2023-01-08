package com.registerapp.registerServerAPI.payload.request;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private Long user_id;
    private String name;
    private String second_name;
    private String email;
    private String password;
}
