package com.registerapp.registerServerAPI.payload.request;

import lombok.Data;

@Data
public class GradeUpdateRequest {
    private Long grade_id;
    private Long grade_type_id;
    private Long grade_value_id;
    private Integer weight;
    private String comment;
}
