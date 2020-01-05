package com.example.demobook.security.application;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demobook.security.config.JwtTokenProvider;
import com.example.demobook.security.domain.AuthenticationRequest;
import com.example.demobook.user.application.UserService;

@Service
public class AuthenticationService {

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private UserService userService;

    public AuthenticationService(
            AuthenticationManager authenticationManager,
            JwtTokenProvider jwtTokenProvider,
            UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    /**
     * 가입된 유저가 로그인해서 유저 인증이 완료했을 경우, 유저 jwt 토큰을 발급하여 유저에게 전달해준다.
     * @param data AuthenticationRequest
     * @return user jwt token
     * @throws Exception
     */
    public ResponseEntity signin(@RequestBody AuthenticationRequest data, HttpServletResponse response) throws Exception {
        try {
            String userName = data.getUsername();
            final Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, data.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtTokenProvider.createToken(userName,
                                                        userService.findByUserId(userName)
                                                                   .orElseThrow(() ->
                                                                                        new UsernameNotFoundException("Username " + userName + " not found"))
                                                                   .getUserAuthorizations()
                                                                   .stream()
                                                                   .map(userAuthorization ->
                                                                                userAuthorization.getRoleName())
                                                                   .collect(Collectors.toList()));
            Map<Object, Object> model = new HashMap<>();
            model.put("username", userName);
            model.put("token", token);
            return ok(model);
        }catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}
