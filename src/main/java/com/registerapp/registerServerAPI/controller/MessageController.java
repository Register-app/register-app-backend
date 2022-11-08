package com.registerapp.registerServerAPI.controller;

import com.registerapp.registerServerAPI.entity.Message;
import com.registerapp.registerServerAPI.payload.request.MessageCreateRequest;
import com.registerapp.registerServerAPI.payload.request.MessageGetRequest;
import com.registerapp.registerServerAPI.payload.response.MessageGetResponse;
import com.registerapp.registerServerAPI.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private MessageService messageService;

    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('USER')")
    public List<MessageGetResponse> getListMessage(@Valid @RequestBody MessageGetRequest messageGetRequest) throws Exception {
        return messageService.getListMessage(messageGetRequest);
    }

    @MessageMapping("/chat")
    @PreAuthorize("hasAnyRole('USER')")
    public void sendMessage(@Valid @RequestBody MessageCreateRequest messageCreateRequest) throws Exception {
        messageService.sendMessage(messageCreateRequest);
    }

}
