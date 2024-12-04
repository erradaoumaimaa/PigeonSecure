package com.oumaima.pigeonSecure.dto.user;
import lombok.*;

import lombok.Builder;

@Builder
public record UserDTO(
        Long id,
        String username,
        String email,
        String password
) {}
