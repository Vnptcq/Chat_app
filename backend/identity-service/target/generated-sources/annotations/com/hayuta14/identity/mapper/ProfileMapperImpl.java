package com.hayuta14.identity.mapper;

import com.hayuta14.identity.dto.request.ProfileCreationRequest;
import com.hayuta14.identity.dto.request.UserCreationRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class ProfileMapperImpl implements ProfileMapper {

    @Override
    public ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        ProfileCreationRequest.ProfileCreationRequestBuilder profileCreationRequest = ProfileCreationRequest.builder();

        profileCreationRequest.username( request.getUsername() );
        profileCreationRequest.email( request.getEmail() );
        profileCreationRequest.firstName( request.getFirstName() );
        profileCreationRequest.lastName( request.getLastName() );
        profileCreationRequest.dob( request.getDob() );
        profileCreationRequest.city( request.getCity() );

        return profileCreationRequest.build();
    }
}
