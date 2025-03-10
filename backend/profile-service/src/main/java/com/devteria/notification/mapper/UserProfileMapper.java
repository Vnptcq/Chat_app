package com.hayuta14.notification.mapper;

import org.mapstruct.Mapper;

import com.hayuta14.notification.dto.request.ProfileCreationRequest;
import com.hayuta14.notification.dto.response.UserProfileResponse;
import com.hayuta14.notification.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileReponse(UserProfile entity);
}
