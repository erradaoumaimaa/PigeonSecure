package com.oumaima.pigeonSecure.service.pigeon;

import com.oumaima.pigeonSecure.dto.pigeon.PigeonRequestDTO;
import com.oumaima.pigeonSecure.dto.pigeon.PigeonResponseDTO;

public interface PigeonService {
    PigeonResponseDTO createPigeon(PigeonRequestDTO pigeonRequestDTO);
}
