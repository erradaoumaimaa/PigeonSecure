package com.oumaima.pigeonSecure.service.user;

import com.oumaima.pigeonSecure.dto.user.UserRequestDTO;
import com.oumaima.pigeonSecure.dto.user.UserResponseDTO;
import com.oumaima.pigeonSecure.entity.User;
import com.oumaima.pigeonSecure.exception.user.UserAlreadyExistsException;
import com.oumaima.pigeonSecure.exception.user.UserNotFoundException;


public interface UserService {

    UserResponseDTO createUser(UserRequestDTO userRequestDTO) throws UserAlreadyExistsException;

    UserResponseDTO getUserById(Long userId) throws UserNotFoundException;

    User findUserByUsername(String username);

    User updateUserRole(String username, String newRole) throws UserNotFoundException;


}
