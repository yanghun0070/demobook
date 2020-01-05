package com.example.demobook.security.presentation.api;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demobook.security.application.AuthenticationService;
import com.example.demobook.security.application.LoginUserDetails;
import com.example.demobook.security.domain.AuthenticationRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationRestController {

    private AuthenticationService authenticationService;

    public AuthenticationRestController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**
     * 가입된 유저가 로그인해서 유저 인증이 완료했을 경우, 유저 jwt 토큰을 발급하여 유저에게 전달해준다.
     * @param data AuthenticationRequest
     * @return user jwt token
     * @throws Exception
     */
    @PostMapping("signin")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data, HttpServletResponse response) throws Exception {
        return authenticationService.signin(data, response);
    }

    /**
     * 현재, 유저 정보를 조회한다.
     * @param userDetails
     * @return
     */
    @GetMapping("me")
    public ResponseEntity currentUser(@AuthenticationPrincipal LoginUserDetails userDetails){
        Map<Object, Object> model = new HashMap<>();
        model.put("username", userDetails.getUsername());
        model.put("roles", userDetails.getAuthorities()
                                   .stream()
                                   .map(a -> ((GrantedAuthority) a).getAuthority())
                                   .collect(Collectors.toList()));
        return ok(model);
    }
}
