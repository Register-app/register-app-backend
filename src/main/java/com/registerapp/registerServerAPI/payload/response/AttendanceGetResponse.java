package com.registerapp.registerServerAPI.payload.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AttendanceGetResponse {
    private Long attendance_id;
    private Long student_id;
    private String subject;
    private String attendance_type;
    private LocalDateTime date;


}
