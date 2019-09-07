package com.example.demobook.security.application;

import com.example.demobook.user.domain.User;
import com.example.demobook.user.infra.JpaUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailsService implements UserDetailsService {

    private JpaUserRepository jpaUserRepository;

    public LoginUserDetailsService(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = jpaUserRepository.findByUserId(userId)
                .orElseThrow(IllegalArgumentException::new);
        return new LoginUserDetails(user);
    }
}
