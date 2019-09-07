package com.example.demobook.user.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    /**
     * 유저 로그인 페이지
     * @return
     */
    @GetMapping("/user/login")
    public String loginUser() {
        return "user/login";
    }


    /**
     * 유저 회원가입 페이지
     * @return
     */
    @GetMapping("/user/join")
    public String joinUser() {
        return "user/join";
    }

}
