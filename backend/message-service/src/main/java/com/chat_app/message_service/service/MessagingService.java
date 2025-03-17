package com.chat_app.message_service.service;


import com.chat_app.message_service.dto.request.MessageGetRequest;
import com.chat_app.message_service.dto.request.MessageSendRequest;
import com.chat_app.message_service.dto.response.MessageResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessagingService {

    @Transactional
    public void sendMessage(MessageSendRequest message) {

    }

    public List<MessageResponse> getMessages(MessageGetRequest message) {
        List<MessageResponse> messages = new ArrayList<>();
        return messages;
    }

}
