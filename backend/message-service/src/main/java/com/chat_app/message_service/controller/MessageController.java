package com.chat_app.message_service.controller;


import com.chat_app.message_service.dto.request.ConnectRequest;
import com.chat_app.message_service.dto.request.MessageGetRequest;
import com.chat_app.message_service.dto.request.MessageSendRequest;
import com.chat_app.message_service.dto.response.ApiResponse;
import com.chat_app.message_service.dto.response.ConnectResponse;
import com.chat_app.message_service.dto.response.MessageResponse;
import com.chat_app.message_service.entity.ChatMessage;
import com.chat_app.message_service.service.MessagingService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessageController {

    SimpMessagingTemplate messagingTemplate;
    MessagingService messagingService;
    SimpMessagingTemplate simpMessagingTemplate;

    //when connect to server and disconnect to server

    //connect->add status online->check unseen message
    @MessageMapping("/user.connect")
    public ConnectResponse userConnect(@Payload ConnectRequest connectRequest) {
        return messagingService.userConnect(connectRequest);
    }

    //disconnect-set status
    @MessageMapping("/user.disconnect")
    public ConnectResponse userDisconnect(@Payload ConnectRequest connectRequest) {
        return messagingService.userDisconnect(connectRequest);
    }

    //when connected check unseen message and send to broker /queue/useenMessage
    //check message 1-1
    @MessageMapping("/user.unseenMessage")
    public List<MessageGetRequest> userUnseenMessage(@Payload ConnectRequest connectRequest) {
        simpMessagingTemplate.convertAndSendToUser(connectRequest.getUserId(),"/queue/unseenMessage", messagingService.unseenMessages(connectRequest.getUserId()));
        return messagingService.unseenMessages(connectRequest.getUserId());
    }

    //one to one chat
    @MessageMapping("/chat.sendMessageToUser")
    public void sendMessageToUser(@Valid MessageSendRequest messageSendRequest) {
        messagingTemplate.convertAndSend("/topic/chat", messageSendRequest);
    }


    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        System.out.println(headerAccessor.getSessionAttributes());
        return chatMessage;
    }

}
