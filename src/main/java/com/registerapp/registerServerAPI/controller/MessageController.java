package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.payload.request.MessageCreateRequest;
import com.registerapp.registerServerAPI.payload.request.MessageGetRequest;
import com.registerapp.registerServerAPI.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private MessageService messageService;

    @MessageMapping("/message")
    public void sendMessage(@Payload MessageCreateRequest messageCreateRequest) throws Exception {
        messageService.sendMessage(messageCreateRequest);
    }
    @PostMapping("/listmessage")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<?> getListMessage(@Valid @RequestBody MessageGetRequest messageGetRequest) throws Exception {
        return ResponseEntity.ok(messageService.getListMessage(messageGetRequest));
    }
}
