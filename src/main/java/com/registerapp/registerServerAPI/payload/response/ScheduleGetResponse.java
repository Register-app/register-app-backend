package com.registerapp.registerServerAPI.payload.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ScheduleGetResponse {
    private Long schedule_id;
    private Long teacher_id;
    private Long register_id;
    private Long class_id;
    private String class_name;
    private String subject;
    private String name;
    private String second_name;
    private String schedule_type_id;
    private LocalDateTime date;


}
