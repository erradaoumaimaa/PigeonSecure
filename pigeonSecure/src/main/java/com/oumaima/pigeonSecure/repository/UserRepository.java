package com.oumaima.pigeonSecure.repository;

import com.oumaima.pigeonSecure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
