package com.oumaima.pigeonSecure.dto.pigeon;

import com.oumaima.pigeonSecure.entity.enums.Gender;

public record PigeonRequestDTO(
        String numberBague,
        Gender gender,
        int age,
        String color,
        Long userId,
        Long competitionId
) {
    public Long getCompetitionId() {
        return competitionId;
    }

    public String getNumberBague() {
        return numberBague;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public Long getUserId() {
        return userId;
    }
}