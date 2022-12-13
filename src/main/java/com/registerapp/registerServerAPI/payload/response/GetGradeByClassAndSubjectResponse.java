package com.registerapp.registerServerAPI.payload.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GetGradeByClassAndSubjectResponse {
    private Long grade_id;
    private Number weight;
    private String comment;
    private LocalDateTime date;
    private Long student_id;
    private String type_value;
    private String type_text;
    private String text;
    private Float value;
}
