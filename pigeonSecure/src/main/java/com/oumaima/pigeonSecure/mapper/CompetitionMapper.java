package com.oumaima.pigeonSecure.mapper;


import com.oumaima.pigeonSecure.dto.competition.CompetitionRequestDTO;
import com.oumaima.pigeonSecure.dto.competition.CompetitionResponseDTO;
import com.oumaima.pigeonSecure.entity.Competition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")

public interface CompetitionMapper {
    Competition toEntity(CompetitionRequestDTO competitionRequestDTO);
    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "pigeons", ignore = true)
    })
    CompetitionResponseDTO toResponse(Competition competition);
}
