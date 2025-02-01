package com.example.luna.domain.user;

public record RegisterDTO(
        String login,
        String password,
        UserRole role
) {
}
