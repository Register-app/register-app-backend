package com.registerapp.registerServerAPI.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentGetResponse {
    private Long student_id;
    private String name;
    private String second_name;
}
