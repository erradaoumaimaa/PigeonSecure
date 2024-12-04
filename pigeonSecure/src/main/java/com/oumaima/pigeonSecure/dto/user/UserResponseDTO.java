package com.oumaima.pigeonSecure.dto.user;

import com.oumaima.pigeonSecure.entity.enums.Role;

public record UserResponseDTO(
         Long id,
         String username,
         String email,
         Role role
) {}
