package com.oumaima.pigeonSecure.service.competition.impl;

import com.oumaima.pigeonSecure.dto.competition.CompetitionRequestDTO;
import com.oumaima.pigeonSecure.dto.competition.CompetitionResponseDTO;
import com.oumaima.pigeonSecure.entity.Competition;
import com.oumaima.pigeonSecure.entity.User;
import com.oumaima.pigeonSecure.mapper.CompetitionMapper;
import com.oumaima.pigeonSecure.repository.CompetitionRepository;
import com.oumaima.pigeonSecure.repository.UserRepository;
import com.oumaima.pigeonSecure.service.competition.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final CompetitionMapper competitionMapper;
    private final UserRepository userRepository;
    @Override
    public CompetitionResponseDTO createCompetition(CompetitionRequestDTO competitionRequestDTO) {
        User user = userRepository.findById(competitionRequestDTO.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found!"));

        Competition competition = competitionMapper.toEntity(competitionRequestDTO);

        competition.setUser(user);

        competition = competitionRepository.save(competition);

        return competitionMapper.toResponse(competition);
    }



}
