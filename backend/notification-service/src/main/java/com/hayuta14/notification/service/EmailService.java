package com.hayuta14.notification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hayuta14.notification.dto.request.EmailRequest;
import com.hayuta14.notification.dto.request.SendEmailRequest;
import com.hayuta14.notification.dto.request.Sender;
import com.hayuta14.notification.dto.response.EmailResponse;
import com.hayuta14.notification.exception.AppException;
import com.hayuta14.notification.exception.ErrorCode;
import com.hayuta14.notification.repository.httpclient.EmailClient;

import feign.FeignException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailService {
    EmailClient emailClient;

    @Value("${notification.email.brevo-apikey}")
    @NonFinal
    String apiKey;

    public EmailResponse sendEmail(SendEmailRequest request) {
        EmailRequest emailRequest = EmailRequest.builder()
                .sender(Sender.builder()
                        .name("Devteria DotCom")
                        .email("devteriadotcom@gmail.com")
                        .build())
                .to(List.of(request.getTo()))
                .subject(request.getSubject())
                .htmlContent(request.getHtmlContent())
                .build();
        try {
            return emailClient.sendEmail(apiKey, emailRequest);
        } catch (FeignException e) {
            throw new AppException(ErrorCode.CANNOT_SEND_EMAIL);
        }
    }
}
