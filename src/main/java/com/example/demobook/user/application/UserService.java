package com.example.demobook.user.application;

import com.example.demobook.user.domain.User;
import com.example.demobook.user.infra.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    private JpaUserRepository jpaUserRepository;

    public UserService(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    public void join(User user) throws Exception {

        Optional<User> joinedUser = jpaUserRepository.findByUserId(user.getUserId());

        jpaUserRepository.save(new User(user.getUserId(),
                new BCryptPasswordEncoder().encode(user.getPassword()),
                LocalDateTime.now()));
    }
}
