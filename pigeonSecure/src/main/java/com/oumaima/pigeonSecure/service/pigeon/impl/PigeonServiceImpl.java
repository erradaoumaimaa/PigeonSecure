package com.oumaima.pigeonSecure.service.pigeon.impl;

import com.oumaima.pigeonSecure.dto.pigeon.PigeonRequestDTO;
import com.oumaima.pigeonSecure.dto.pigeon.PigeonResponseDTO;
import com.oumaima.pigeonSecure.entity.Pigeon;
import com.oumaima.pigeonSecure.entity.Competition;
import com.oumaima.pigeonSecure.entity.User;
import com.oumaima.pigeonSecure.mapper.PigeonMapper;
import com.oumaima.pigeonSecure.repository.PigeonRepository;
import com.oumaima.pigeonSecure.repository.CompetitionRepository;
import com.oumaima.pigeonSecure.repository.UserRepository;
import com.oumaima.pigeonSecure.service.pigeon.PigeonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PigeonServiceImpl implements PigeonService {

    private final PigeonRepository pigeonRepository;
    private final UserRepository userRepository;
    private final CompetitionRepository competitionRepository;
    private final PigeonMapper pigeonMapper;

    @Override
    public PigeonResponseDTO createPigeon(PigeonRequestDTO pigeonRequestDTO) {
        User user = userRepository.findById(pigeonRequestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Competition competition = null;
        if (pigeonRequestDTO.getCompetitionId() != null) {
            competition = competitionRepository.findById(pigeonRequestDTO.getCompetitionId())
                    .orElseThrow(() -> new RuntimeException("Competition not found"));
        }

        Pigeon pigeon = pigeonMapper.toEntity(pigeonRequestDTO);
        pigeon.setUser(user);

        if (competition != null) {
            pigeon.setCompetition(competition);
        }

        Pigeon savedPigeon = pigeonRepository.save(pigeon);

        return pigeonMapper.toResponse(savedPigeon);
    }
}
