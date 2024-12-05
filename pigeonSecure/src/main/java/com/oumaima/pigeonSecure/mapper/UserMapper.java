package com.oumaima.pigeonSecure.mapper;


import com.oumaima.pigeonSecure.dto.user.*;
import com.oumaima.pigeonSecure.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO toResponse(User user);


    @Mapping(target = "createdAt", ignore = true)
    User toEntity(UserRequestDTO userRequestDTO);

    @Mapping(target = "id", ignore = true)
    void updateUserFromDTO(UserRequestDTO userRequestDTO, @MappingTarget User user);

}
