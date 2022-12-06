package com.registerapp.registerServerAPI.payload.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GradeAddResponse {
    private Long grade_id;
    private Long student_id;
    private String type_value;
    private String type_text;
    private Float value;
    private String text;
    private LocalDateTime date;
    private Integer weight;
    private String comment;
}
