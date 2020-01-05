package com.example.demobook.user.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demobook.user.domain.UserAuthorization;

public interface JpaUserAuthorizationRepository extends JpaRepository<UserAuthorization, Integer> {
}
