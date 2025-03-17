package com.chat_app.message_service.dto.response;

import com.chat_app.message_service.constant.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConnectResponse {
    String userId;
    String status = Status.OFFLINE.toString();
}
