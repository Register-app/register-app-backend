package com.registerapp.registerServerAPI.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Data
@Builder
public class MessageGetResponse {
    private Long message_id;
    private String content;
    private LocalTime time;
    private LocalDate date;
    private Long sender_id;
    private Long receiver_id;
    private String sender_name;
    private String sender_second_name;
}
