package com.oumaima.pigeonSecure.dto.user;


import jakarta.validation.constraints.*;

public record UserRequestDTO(
        @NotBlank(message = "username is required")
        String username,

        @NotBlank(message = "Password cannot be empty")
        @Size(min = 8, message = "Password must be at least 8 characters long")
        String password
) {}
