package com.chat_app.message_service.mapper;

import com.chat_app.message_service.dto.request.Messages;
import com.chat_app.message_service.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message toMessage(Messages message);
    Messages toMessages(Message message);
}
