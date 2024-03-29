package com.registerapp.registerServerAPI.payload.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudentGetResponse {
    private Long user_id;
    private Long student_id;
    private String name;
    private String second_name;
    private String email;
    private Long class_id;
    private List<Long> guardian_id;
}
