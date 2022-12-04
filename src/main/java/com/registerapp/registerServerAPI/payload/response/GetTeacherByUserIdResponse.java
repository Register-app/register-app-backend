package com.registerapp.registerServerAPI.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetTeacherByUserIdResponse {
    private Long teacher_id;
}
