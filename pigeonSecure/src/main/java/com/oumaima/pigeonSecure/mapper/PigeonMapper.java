package com.oumaima.pigeonSecure.mapper;

import com.oumaima.pigeonSecure.dto.pigeon.PigeonRequestDTO;
import com.oumaima.pigeonSecure.dto.pigeon.PigeonResponseDTO;
import com.oumaima.pigeonSecure.entity.Pigeon;


import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PigeonMapper {

    PigeonResponseDTO toResponse(Pigeon pigeon);
    Pigeon toEntity(PigeonRequestDTO pigeonRequestDTO);

}
