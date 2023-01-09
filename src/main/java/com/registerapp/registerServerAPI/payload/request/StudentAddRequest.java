package com.registerapp.registerServerAPI.payload.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class StudentAddRequest {
    private Long user_id;
    private Long class_id;
}
