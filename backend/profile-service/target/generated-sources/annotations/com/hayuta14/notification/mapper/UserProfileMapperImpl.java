package com.hayuta14.notification.mapper;

import com.hayuta14.notification.dto.request.ProfileCreationRequest;
import com.hayuta14.notification.dto.response.UserProfileResponse;
import com.hayuta14.notification.entity.UserProfile;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class UserProfileMapperImpl implements UserProfileMapper {

    @Override
    public UserProfile toUserProfile(ProfileCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        UserProfile.UserProfileBuilder userProfile = UserProfile.builder();

        userProfile.userId( request.getUserId() );
        userProfile.username( request.getUsername() );
        userProfile.email( request.getEmail() );
        userProfile.firstName( request.getFirstName() );
        userProfile.lastName( request.getLastName() );
        userProfile.dob( request.getDob() );
        userProfile.city( request.getCity() );

        return userProfile.build();
    }

    @Override
    public UserProfileResponse toUserProfileReponse(UserProfile entity) {
        if ( entity == null ) {
            return null;
        }

        UserProfileResponse.UserProfileResponseBuilder userProfileResponse = UserProfileResponse.builder();

        userProfileResponse.id( entity.getId() );
        userProfileResponse.username( entity.getUsername() );
        userProfileResponse.email( entity.getEmail() );
        userProfileResponse.firstName( entity.getFirstName() );
        userProfileResponse.lastName( entity.getLastName() );
        userProfileResponse.dob( entity.getDob() );
        userProfileResponse.city( entity.getCity() );

        return userProfileResponse.build();
    }
}
