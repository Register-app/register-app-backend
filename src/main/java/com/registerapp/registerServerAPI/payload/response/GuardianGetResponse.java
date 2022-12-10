package com.registerapp.registerServerAPI.payload.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GuardianGetResponse {
    private Long user_id;
    private Long guardian_id;
    private String name;
    private String second_name;
    private String email;
    private List<Long> student_id;
}
