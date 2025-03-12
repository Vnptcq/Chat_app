package com.chat_app.message_service.controller;


import com.chat_app.message_service.dto.request.MessageGetRequest;
import com.chat_app.message_service.dto.request.MessageSendRequest;
import com.chat_app.message_service.dto.response.ApiResponse;
import com.chat_app.message_service.dto.response.MessageResponse;
import com.chat_app.message_service.service.MessagingService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessageController {
    MessagingService messagingService;


    @PostMapping("send")
    void sendMessage(@RequestBody @Valid MessageSendRequest message) {
         messagingService.sendMessage(message);
    }

//    @GetMapping("get")
//    ApiResponse<List<MessageResponse>> getMessage(@RequestBody @Valid MessageGetRequest message) {
//        return ApiResponse.<List<MessageResponse>>builder().result(messagingService.getMessages(message)).build();
//    }
}
