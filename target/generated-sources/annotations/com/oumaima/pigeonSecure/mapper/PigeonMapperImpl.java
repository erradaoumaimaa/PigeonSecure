package com.oumaima.pigeonSecure.mapper;

import com.oumaima.pigeonSecure.dto.pigeon.PigeonRequestDTO;
import com.oumaima.pigeonSecure.dto.pigeon.PigeonResponseDTO;
import com.oumaima.pigeonSecure.entity.Pigeon;
import com.oumaima.pigeonSecure.entity.enums.Gender;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-06T16:30:07+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class PigeonMapperImpl implements PigeonMapper {

    @Override
    public PigeonResponseDTO toResponse(Pigeon pigeon) {
        if ( pigeon == null ) {
            return null;
        }

        Long id = null;
        String numberBague = null;
        Gender gender = null;
        int age = 0;
        String color = null;

        id = pigeon.getId();
        numberBague = pigeon.getNumberBague();
        gender = pigeon.getGender();
        age = pigeon.getAge();
        color = pigeon.getColor();

        Long userId = null;
        Long competitionId = null;

        PigeonResponseDTO pigeonResponseDTO = new PigeonResponseDTO( id, numberBague, gender, age, color, userId, competitionId );

        return pigeonResponseDTO;
    }

    @Override
    public Pigeon toEntity(PigeonRequestDTO pigeonRequestDTO) {
        if ( pigeonRequestDTO == null ) {
            return null;
        }

        Pigeon.PigeonBuilder pigeon = Pigeon.builder();

        pigeon.numberBague( pigeonRequestDTO.numberBague() );
        pigeon.gender( pigeonRequestDTO.gender() );
        pigeon.age( pigeonRequestDTO.age() );
        pigeon.color( pigeonRequestDTO.color() );

        return pigeon.build();
    }
}
