package com.hayuta14.identity.mapper;

import org.mapstruct.Mapper;

import com.hayuta14.identity.dto.request.ProfileCreationRequest;
import com.hayuta14.identity.dto.request.UserCreationRequest;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);
}
