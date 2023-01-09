package com.registerapp.registerServerAPI.payload.request;

import lombok.Data;

import java.util.List;

@Data
public class StudentUpdateRequest {
    private Long student_id;
    private Long class_id;
}
