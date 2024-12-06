package com.oumaima.pigeonSecure.dto.competition;

import com.oumaima.pigeonSecure.dto.pigeon.PigeonResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public record CompetitionResponseDTO(
        Long id,
        String name,
        LocalDateTime startTime,
        LocalDateTime endTime,
        double latitudeGPS,
        double longitudeGPS,
        int pigeonCount,
        Long userId,
        List<PigeonResponseDTO> pigeons
) {}
