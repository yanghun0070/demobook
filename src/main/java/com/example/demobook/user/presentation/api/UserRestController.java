package com.example.demobook.user.presentation.api;

import com.example.demobook.security.domain.AuthenticationRequest;
import com.example.demobook.user.application.UserService;
import com.example.demobook.user.domain.User;
import com.example.demobook.user.presentation.vo.UserVo;
import com.example.demobook.security.application.LoginUserDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    private final AuthenticationManager authenticationManager;

    public UserRestController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * 회원 가입
     * @param userVo 유저 정보
     * @throws Exception
     */
    @PostMapping("join")
    public void join(@RequestBody @Valid UserVo userVo) throws Exception {

        //패스워드가 일치하지 않을 시
        if(!userVo.getPassword().equals(userVo.getConfirmPassword())) {
            throw new IllegalArgumentException(
                    userVo.getPassword() + ", " + userVo.getConfirmPassword() +
                    " 두 개의 패스워드가 일치하지 않습니다.");
        }

        User user = new ModelMapper().map(userVo, User.class);
        userService.join(user);
    }


    /**
     * 유저 로그인
     * @param data
     * @param session
     * @return
     * @throws Exception
     */
    @PostMapping("login")
    public ResponseEntity<Boolean> login(@RequestBody AuthenticationRequest data, HttpSession session,
                                         HttpServletRequest request) throws Exception {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                data.getUsername(), data.getPassword());
        try {
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    SecurityContextHolder.getContext());
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.ok(false);
        }

    }

}
