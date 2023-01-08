package com.registerapp.registerServerAPI.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAddResponse {
    private Long user_id;
    private String name;
    private String second_name;
    private String email;
}
