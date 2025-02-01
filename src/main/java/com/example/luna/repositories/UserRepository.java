package com.example.luna.repositories;

import com.example.luna.domain.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserDetails findByLogin(String login);
}
