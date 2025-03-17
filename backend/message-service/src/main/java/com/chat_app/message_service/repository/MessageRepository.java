package com.chat_app.message_service.repository;

import com.chat_app.message_service.constant.MessageStatus;
import com.chat_app.message_service.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
    List<Message> findByReceiverIdAndStatus(String userId, MessageStatus messageStatus);
}
