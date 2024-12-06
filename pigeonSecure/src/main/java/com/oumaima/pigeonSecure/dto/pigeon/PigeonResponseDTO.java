package com.oumaima.pigeonSecure.dto.pigeon;

import com.oumaima.pigeonSecure.entity.enums.Gender;

public record PigeonResponseDTO(
        Long id,
        String numberBague,
        Gender gender,
        int age,
        String color,
        Long userId,
        Long competitionId
) {
}