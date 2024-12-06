package com.oumaima.pigeonSecure.controller;

import com.oumaima.pigeonSecure.dto.competition.CompetitionRequestDTO;
import com.oumaima.pigeonSecure.dto.competition.CompetitionResponseDTO;
import com.oumaima.pigeonSecure.service.competition.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/competitions")
@RequiredArgsConstructor
public class CompetitionController {

    private final CompetitionService competitionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompetitionResponseDTO createCompetition(@RequestBody CompetitionRequestDTO competitionRequestDTO) {
        return competitionService.createCompetition(competitionRequestDTO);
    }
}
