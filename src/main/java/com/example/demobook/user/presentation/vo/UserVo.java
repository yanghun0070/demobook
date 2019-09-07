package com.example.demobook.user.presentation.vo;


import javax.validation.constraints.NotEmpty;

public class UserVo {

    @NotEmpty
    private String userId; //유저 id
    @NotEmpty
    private String password; //비밀번호
    @NotEmpty
    private String confirmPassword; //확인 비밀번호

    private UserVo() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
