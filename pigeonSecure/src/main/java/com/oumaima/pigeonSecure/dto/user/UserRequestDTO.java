package com.oumaima.pigeonSecure.dto.user;

import com.oumaima.pigeonSecure.entity.enums.Role;

import jakarta.validation.constraints.*;

public record UserRequestDTO(
        @Email(message = "Invalid email format")
        @NotBlank(message = "Email is required")
        String email,

        @NotBlank(message = "Password cannot be empty")
        @Size(min = 8, message = "Password must be at least 8 characters long")
        String password,

        Role role
) {}
