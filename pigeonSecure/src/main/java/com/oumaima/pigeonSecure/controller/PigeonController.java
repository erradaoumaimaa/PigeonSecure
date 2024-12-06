package com.oumaima.pigeonSecure.controller;

import com.oumaima.pigeonSecure.dto.pigeon.PigeonRequestDTO;
import com.oumaima.pigeonSecure.dto.pigeon.PigeonResponseDTO;
import com.oumaima.pigeonSecure.service.pigeon.PigeonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/pigeons")
@RequiredArgsConstructor
public class PigeonController {

    private final PigeonService pigeonService;

    @PostMapping
    public ResponseEntity<PigeonResponseDTO> createPigeon(@RequestBody PigeonRequestDTO pigeonRequestDTO) {
        PigeonResponseDTO pigeonResponseDTO = pigeonService.createPigeon(pigeonRequestDTO);
        return new ResponseEntity<>(pigeonResponseDTO, HttpStatus.CREATED);
    }
}
