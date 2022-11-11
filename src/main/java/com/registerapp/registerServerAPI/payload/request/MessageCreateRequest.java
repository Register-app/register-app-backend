package com.registerapp.registerServerAPI.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class MessageCreateRequest {
    @NotBlank
    private String content;
    @NotBlank
    private Long sender_id;
    @NotBlank
    private Long receiver_id;
}
