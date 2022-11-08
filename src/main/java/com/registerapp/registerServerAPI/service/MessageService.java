package com.registerapp.registerServerAPI.service;

import com.registerapp.registerServerAPI.entity.Message;
import com.registerapp.registerServerAPI.entity.User;
import com.registerapp.registerServerAPI.payload.request.MessageCreateRequest;
import com.registerapp.registerServerAPI.payload.request.MessageGetRequest;
import com.registerapp.registerServerAPI.payload.response.MessageGetResponse;
import com.registerapp.registerServerAPI.repository.MessageRepository;
import com.registerapp.registerServerAPI.repository.UserRepository;
import org.springframework.web.server.ResponseStatusException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {

    private MessageRepository messageRepository;
    private UserRepository userRepository;
    private SimpMessagingTemplate simpMessagingTemplate;

    @Transactional
    public void sendMessage(MessageCreateRequest messageCreateRequest) {
        User user = userRepository.findById(messageCreateRequest.getSender_id()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Nie znaleziono użytkownika o takim id"));

        messageRepository.save(new Message(
                messageCreateRequest.getContent(),
                messageCreateRequest.getTime(),
                messageCreateRequest.getDate(),
                user,
                messageCreateRequest.getReceiver_id()
        ));

        simpMessagingTemplate.convertAndSend("/topic/messages/"+ messageCreateRequest.getReceiver_id(), messageCreateRequest);
    }

    public List<MessageGetResponse> getListMessage(MessageGetRequest messageGetRequest) {
        List<Message> messages = messageRepository.findAllByUserIdOrReceiver(messageGetRequest.getSender_id(), messageGetRequest.getReceiver_id());

        return (List<MessageGetResponse>) messages.stream()
                .map(message -> mapToMessageGetResponse(message));
    }

    private MessageGetResponse mapToMessageGetResponse(Message message) {
        return MessageGetResponse.builder()
                .message_id(message.getMessage_id())
                .content(message.getContent())
                .time(message.getTime())
                .date(message.getDate())
                .receiver_id(message.getReceiver_id())
                .sender_id(message.getSender_id().getUser_id())
                .build();
    }
}
