package com.example.demobook.user.application;

import com.example.demobook.user.domain.User;
import com.example.demobook.user.domain.UserAuthorization;
import com.example.demobook.user.infra.JpaUserAuthorizationRepository;
import com.example.demobook.user.infra.JpaUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    private JpaUserRepository jpaUserRepository;
    private JpaUserAuthorizationRepository JpaUserAuthorizationRepository;

    public UserService(JpaUserRepository jpaUserRepository,
                       JpaUserAuthorizationRepository JpaUserAuthorizationRepository) {
        this.jpaUserRepository = jpaUserRepository;
        this.JpaUserAuthorizationRepository = JpaUserAuthorizationRepository;
    }

    public void join(User user) throws Exception {
        Optional<User> joinUser = jpaUserRepository.findByUserId(user.getUserId());
        if(!joinUser.isPresent()) {
            User joinedUser = jpaUserRepository.saveAndFlush(new User(user.getUserId(),
                                            new BCryptPasswordEncoder().encode(user.getPassword()),
                                            LocalDateTime.now()));
            UserAuthorization userAuthorization =
                    new UserAuthorization(joinedUser, "ROLE_USER");
            JpaUserAuthorizationRepository.save(userAuthorization);
        }
    }

    /**
     * ID 에 의해 유저 정보를 찾는다.
     * @param userId ID
     * @return 유저 정보
     * @throws Exception
     */
    public Optional<User> findByUserId(String userId) throws Exception {
        return jpaUserRepository.findByUserId(userId);
    }
}