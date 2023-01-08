package com.registerapp.registerServerAPI.payload.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GradeAddRequest {
    private Integer weight;
    private String comment;
    private LocalDateTime date;
    private Long student_id;
    private Long grade_type_id;
    private Long grade_value_id;
    private Long class_id;
    private Long teacher_id;
    private Long subject_id;
}
