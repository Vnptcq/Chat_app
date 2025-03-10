package com.hayuta14.gateway.service;

import com.hayuta14.gateway.dto.ApiResponse;
import com.hayuta14.gateway.dto.request.IntrospectRequest;
import com.hayuta14.gateway.dto.response.IntrospectResponse;
import com.hayuta14.gateway.repository.IdentityClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IdentityService {
    IdentityClient identityClient;

    public Mono<ApiResponse<IntrospectResponse>> introspect(String token){
        return identityClient.introspect(IntrospectRequest.builder()
                        .token(token)
                .build());
    }
}
