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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MessageService {

    private MessageRepository messageRepository;
    private UserRepository userRepository;
    private SimpMessagingTemplate simpMessagingTemplate;

    @Transactional
    public void sendMessage(MessageCreateRequest messageCreateRequest) {
        User user = userRepository.findById(messageCreateRequest.getSender_id()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Nie znaleziono użytkownika o takim id"));

        Message message = messageRepository.save(new Message(
                messageCreateRequest.getContent(),
                LocalTime.now().truncatedTo(ChronoUnit.SECONDS),
                LocalDate.now(),
                user,
                messageCreateRequest.getReceiver_id()
        ));

        simpMessagingTemplate.convertAndSend("/user/messages/" + messageCreateRequest.getReceiver_id(), mapToMessageGetResponse(message));
    }

    public List<MessageGetResponse> getListMessage(MessageGetRequest messageGetRequest) {
        List<Message> messages = messageRepository.findAllByUserIdOrReceiver(messageGetRequest.getSender_id(), messageGetRequest.getReceiver_id());
        return messages.stream().map(message -> mapToMessageGetResponse(message)).collect(Collectors.toList());
    }

    private MessageGetResponse mapToMessageGetResponse(Message message) {
        return MessageGetResponse.builder()
                .message_id(message.getMessage_id())
                .content(message.getContent())
                .time(message.getTime())
                .date(message.getDate())
                .receiver_id(message.getReceiver_id())
                .sender_id(message.getSender_id().getUser_id())
                .sender_name(message.getSender_id().getName())
                .sender_second_name(message.getSender_id().getSecond_name())
                .build();
    }
}
