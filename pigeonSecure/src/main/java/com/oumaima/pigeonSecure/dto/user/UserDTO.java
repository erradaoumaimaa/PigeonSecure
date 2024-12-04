package com.oumaima.pigeonSecure.dto.user;
import lombok.*;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserDTO(
        Long id,
        String username,
        LocalDateTime createdAt,
        String password
) {}
