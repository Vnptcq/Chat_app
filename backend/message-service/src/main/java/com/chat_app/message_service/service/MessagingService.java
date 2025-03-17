package com.chat_app.message_service.service;


import com.chat_app.message_service.constant.MessageStatus;
import com.chat_app.message_service.constant.Status;
import com.chat_app.message_service.dto.request.ConnectRequest;
import com.chat_app.message_service.dto.request.MessageGetRequest;
import com.chat_app.message_service.dto.request.MessageSendRequest;
import com.chat_app.message_service.dto.request.Messages;
import com.chat_app.message_service.dto.response.ConnectResponse;
import com.chat_app.message_service.dto.response.MessageResponse;
import com.chat_app.message_service.entity.Message;
import com.chat_app.message_service.entity.UserStatus;
import com.chat_app.message_service.mapper.MessageMapper;
import com.chat_app.message_service.repository.MessageRepository;
import com.chat_app.message_service.repository.UserStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessagingService {

    UserStatusRepository userStatusRepository;
    MessageRepository messageRepository;
    MessageMapper messageMapper;

    public ConnectResponse userConnect(ConnectRequest connectRequest) {
        String userId = connectRequest.getUserId();
        if(userStatusRepository.existsById(userId)) {
            UserStatus userStatus = userStatusRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
            userStatus.setStatus(Status.ONLINE.toString());
            userStatusRepository.save(userStatus);
            ConnectResponse connectResponse = ConnectResponse.builder()
                    .userId(userStatus.getUserId())
                    .status(userStatus.getStatus())
                    .build();
            return connectResponse;
        } else {
            UserStatus userStatus = UserStatus.builder()
                    .userId(connectRequest.getUserId())
                    .status(Status.ONLINE.toString())
                    .build();
            userStatusRepository.save(userStatus);
            ConnectResponse connectResponse = ConnectResponse.builder()
                    .userId(userStatus.getUserId())
                    .status(userStatus.getStatus())
                    .build();
            return connectResponse;
        }
    }

    public ConnectResponse userDisconnect(ConnectRequest connectRequest) {
        String userId = connectRequest.getUserId();
        if(userStatusRepository.existsById(userId)) {
            UserStatus userStatus = userStatusRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
            userStatus.setStatus(Status.OFFLINE.toString());
            userStatusRepository.save(userStatus);
            ConnectResponse connectResponse = ConnectResponse.builder()
                    .userId(userStatus.getUserId())
                    .status(userStatus.getStatus())
                    .build();
            return connectResponse;
        } else {
            throw new ApplicationContextException("user not found when disconnecting");
        }
    }

    public List<MessageGetRequest> unseenMessages(String userId) {
        // Lấy tất cả tin nhắn chưa đọc từ DB
        List<Message> unreadMessages = messageRepository.findByReceiverIdAndStatus(userId, MessageStatus.UNREAD);

        // Nhóm tin nhắn theo senderId
        Map<String, List<Messages>> messagesBySender = unreadMessages.stream()
                .collect(Collectors.groupingBy(
                        Message::getSenderId,
                        Collectors.mapping(messageMapper::toMessages, Collectors.toList())
                ));

        // Chuyển dữ liệu về dạng List<MessageGetRequest>
        return messagesBySender.entrySet().stream()
                .map(entry -> MessageGetRequest.builder()
                        .senderId(entry.getKey())
                        .messages(entry.getValue())
                        .build())
                .toList();

    }

    public void sendMessage(MessageSendRequest message) {
        //webSocketService.sendMessageToUser();
    }

    public List<MessageResponse> getMessages(MessageGetRequest message) {
        List<MessageResponse> messages = new ArrayList<>();
        return messages;
    }

}
