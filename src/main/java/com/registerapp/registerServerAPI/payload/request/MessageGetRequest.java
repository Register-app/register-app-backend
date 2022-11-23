package com.registerapp.registerServerAPI.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MessageGetRequest {
    @NotBlank
    private Long sender_id;
    @NotBlank
    private Long receiver_id;
}