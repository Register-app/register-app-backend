package com.registerapp.registerServerAPI.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentAddResponse {
    private Long student_id;
}
