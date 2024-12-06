package com.oumaima.pigeonSecure.mapper;

import com.oumaima.pigeonSecure.dto.competition.CompetitionRequestDTO;
import com.oumaima.pigeonSecure.dto.competition.CompetitionResponseDTO;
import com.oumaima.pigeonSecure.dto.pigeon.PigeonResponseDTO;
import com.oumaima.pigeonSecure.entity.Competition;
import com.oumaima.pigeonSecure.entity.User;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-06T00:29:50+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class CompetitionMapperImpl implements CompetitionMapper {

    @Override
    public Competition toEntity(CompetitionRequestDTO competitionRequestDTO) {
        if ( competitionRequestDTO == null ) {
            return null;
        }

        Competition.CompetitionBuilder competition = Competition.builder();

        competition.name( competitionRequestDTO.name() );
        competition.startTime( competitionRequestDTO.startTime() );
        competition.endTime( competitionRequestDTO.endTime() );
        competition.latitudeGPS( competitionRequestDTO.latitudeGPS() );
        competition.pigeonCount( competitionRequestDTO.pigeonCount() );
        competition.longitudeGPS( competitionRequestDTO.longitudeGPS() );

        return competition.build();
    }

    @Override
    public CompetitionResponseDTO toResponse(Competition competition) {
        if ( competition == null ) {
            return null;
        }

        Long userId = null;
        Long id = null;
        String name = null;
        LocalDateTime startTime = null;
        LocalDateTime endTime = null;
        double latitudeGPS = 0.0d;
        double longitudeGPS = 0.0d;
        int pigeonCount = 0;

        userId = competitionUserId( competition );
        id = competition.getId();
        name = competition.getName();
        startTime = competition.getStartTime();
        endTime = competition.getEndTime();
        latitudeGPS = competition.getLatitudeGPS();
        longitudeGPS = competition.getLongitudeGPS();
        pigeonCount = competition.getPigeonCount();

        List<PigeonResponseDTO> pigeons = null;

        CompetitionResponseDTO competitionResponseDTO = new CompetitionResponseDTO( id, name, startTime, endTime, latitudeGPS, longitudeGPS, pigeonCount, userId, pigeons );

        return competitionResponseDTO;
    }

    private Long competitionUserId(Competition competition) {
        if ( competition == null ) {
            return null;
        }
        User user = competition.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
