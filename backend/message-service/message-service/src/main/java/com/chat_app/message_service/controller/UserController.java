package com.chat_app.message_service.controller;

import com.chat_app.message_service.dto.request.ConnectRequest;
import com.chat_app.message_service.dto.request.MessageGetRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.List;

public class UserController {
    
    @MessageMapping("/user.unseenMessage")
    public List<MessageGetRequest> userUnseenMessage(@Payload ConnectRequest connectRequest) {
        simpMessagingTemplate.convertAndSendToUser(connectRequest.getUserId(),"/queue/unseenMessage", messagingService.unseenMessages(connectRequest.getUserId()));
        return messagingService.unseenMessages(connectRequest.getUserId());
    }
}
