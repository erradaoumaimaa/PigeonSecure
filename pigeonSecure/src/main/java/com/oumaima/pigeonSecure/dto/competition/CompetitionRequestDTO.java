package com.oumaima.pigeonSecure.dto.competition;

import java.time.LocalDateTime;

public record CompetitionRequestDTO(
        String name,
        LocalDateTime startTime,
        LocalDateTime endTime,
        double latitudeGPS,
        double longitudeGPS,
        int pigeonCount,
        Long userId
) {}
