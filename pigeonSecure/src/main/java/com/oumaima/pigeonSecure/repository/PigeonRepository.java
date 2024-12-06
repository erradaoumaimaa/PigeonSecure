package com.oumaima.pigeonSecure.repository;

import com.oumaima.pigeonSecure.entity.Pigeon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PigeonRepository extends JpaRepository<Pigeon, Long> {
}
