package com.chat_app.message_service.controller;

import com.chat_app.message_service.dto.request.ConnectRequest;
import com.chat_app.message_service.dto.request.MessageGetRequest;
import com.chat_app.message_service.dto.request.MessageSendRequest;
import com.chat_app.message_service.service.MessagingService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    SimpMessagingTemplate simpMessagingTemplate;
    MessagingService messagingService;

    //check unseenMessage
    @MessageMapping("/user.unseenMessage")
    public List<MessageGetRequest> userUnseenMessage(@Payload ConnectRequest connectRequest) {
        simpMessagingTemplate.convertAndSendToUser(connectRequest.getUserId(),"/queue/unseenMessage", messagingService.unseenMessages(connectRequest.getUserId()));
        return messagingService.unseenMessages(connectRequest.getUserId());
    }

    @MessageMapping("/user.sendMessage")
    public void sendUserMessage(@Payload MessageSendRequest messageSendRequest) {
        messagingService.sendMessage(messageSendRequest);
    }
}
