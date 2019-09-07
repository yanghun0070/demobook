package com.example.demobook.user.infra;

import com.example.demobook.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<User, String> {

    /**
     * ID 에 의해 유저를 조회한다.
     * @param userId 유저 ID
     * @return 유저 정보
     */
    public Optional<User> findByUserId(String userId);

}
