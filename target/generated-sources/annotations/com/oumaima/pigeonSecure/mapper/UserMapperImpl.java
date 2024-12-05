package com.oumaima.pigeonSecure.mapper;

import com.oumaima.pigeonSecure.dto.user.UserRequestDTO;
import com.oumaima.pigeonSecure.dto.user.UserResponseDTO;
import com.oumaima.pigeonSecure.entity.User;
import com.oumaima.pigeonSecure.entity.enums.Role;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-05T09:51:43+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponseDTO toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String username = null;
        LocalDateTime createdAt = null;
        Role role = null;

        id = user.getId();
        username = user.getUsername();
        createdAt = user.getCreatedAt();
        role = user.getRole();

        UserResponseDTO userResponseDTO = new UserResponseDTO( id, username, createdAt, role );

        return userResponseDTO;
    }

    @Override
    public User toEntity(UserRequestDTO userRequestDTO) {
        if ( userRequestDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( userRequestDTO.username() );
        user.password( userRequestDTO.password() );

        return user.build();
    }

    @Override
    public void updateUserFromDTO(UserRequestDTO userRequestDTO, User user) {
        if ( userRequestDTO == null ) {
            return;
        }

        user.setPassword( userRequestDTO.password() );
    }
}
