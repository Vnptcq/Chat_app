package com.chat_app.message_service.mapper;

import com.chat_app.message_service.dto.request.Messages;
import com.chat_app.message_service.entity.Message;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-14T00:21:40+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public Message toMessage(Messages message) {
        if ( message == null ) {
            return null;
        }

        Message.MessageBuilder message1 = Message.builder();

        message1.data( message.getData() );
        message1.type( message.getType() );
        message1.timestamp( message.getTimestamp() );

        return message1.build();
    }

    @Override
    public Messages toMessages(Message message) {
        if ( message == null ) {
            return null;
        }

        Messages.MessagesBuilder messages = Messages.builder();

        messages.data( message.getData() );
        messages.type( message.getType() );
        messages.timestamp( message.getTimestamp() );

        return messages.build();
    }
}
