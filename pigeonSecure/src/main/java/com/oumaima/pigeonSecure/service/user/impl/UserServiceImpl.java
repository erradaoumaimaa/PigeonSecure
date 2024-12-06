package com.oumaima.pigeonSecure.service.user.impl;


import com.oumaima.pigeonSecure.dto.user.UserRequestDTO;
import com.oumaima.pigeonSecure.dto.user.UserResponseDTO;
import com.oumaima.pigeonSecure.entity.User;
import com.oumaima.pigeonSecure.entity.enums.Role;
import com.oumaima.pigeonSecure.exception.user.UserAlreadyExistsException;
import com.oumaima.pigeonSecure.exception.user.UserNotFoundException;
import com.oumaima.pigeonSecure.mapper.UserMapper;
import com.oumaima.pigeonSecure.repository.UserRepository;
import com.oumaima.pigeonSecure.service.user.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

        private final UserRepository userRepository;
        private final UserMapper userMapper;
        private final PasswordEncoder passwordEncoder;
        @Override
        @Transactional
        public UserResponseDTO createUser(UserRequestDTO userRequestDTO) throws UserAlreadyExistsException {
            if (userRepository.existsByUsername(userRequestDTO.username())) {
                throw new UserAlreadyExistsException(userRequestDTO.username());
            }
            User user = userMapper.toEntity(userRequestDTO);
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            User savedUser = userRepository.save(user);
            return userMapper.toResponse(savedUser);
        }

    @Override
    public UserResponseDTO getUserById(Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));

        return userMapper.toResponse(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username '" + username + "' not found "));
    }


    @Override
    public User updateUserRole(String username, String newRole) throws UserNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("username '" + username + "'"));

        try {
            Role roleEnum = Role.valueOf(newRole.toUpperCase());
            user.setRole(roleEnum);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid role: " + newRole);
        }

        return userRepository.save(user);
    }




}


