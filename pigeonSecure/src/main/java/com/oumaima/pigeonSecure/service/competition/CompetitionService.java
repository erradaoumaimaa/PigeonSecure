package com.oumaima.pigeonSecure.service.competition;

import com.oumaima.pigeonSecure.dto.competition.CompetitionRequestDTO;
import com.oumaima.pigeonSecure.dto.competition.CompetitionResponseDTO;

public interface CompetitionService {
    CompetitionResponseDTO createCompetition(CompetitionRequestDTO competitionRequestDTO);

}
