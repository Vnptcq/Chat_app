package com.chat_app.message_service.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RedisHash("Message")
public class Message {
    @Id
    int id;
    String senderId;
    String receiverId;
    String data;
    String type;
    String timestamp;
    String status;
}
