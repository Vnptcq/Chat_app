package com.hayuta14.identity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.hayuta14.identity.dto.request.UserCreationRequest;
import com.hayuta14.identity.dto.request.UserUpdateRequest;
import com.hayuta14.identity.dto.response.UserResponse;
import com.hayuta14.identity.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
