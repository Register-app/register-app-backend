package com.registerapp.registerServerAPI.payload.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GetGradeByStudentIdResponse {
    private LocalDateTime date;
    private Long student_id;
    private String type_text;
    private String value_text;
    private String subject;
}
