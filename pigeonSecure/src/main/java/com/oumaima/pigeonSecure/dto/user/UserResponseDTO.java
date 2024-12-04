package com.oumaima.pigeonSecure.dto.user;

import com.oumaima.pigeonSecure.entity.enums.Role;

import java.time.LocalDateTime;

public record UserResponseDTO( Long id,String username, LocalDateTime createdAt,Role role) {}
