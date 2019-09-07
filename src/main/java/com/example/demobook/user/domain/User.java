package com.example.demobook.user.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @Column(name = "user_id")
    private String userId; //유저 ID
    private String password; //비밀 번호
    private LocalDateTime createDate; //생성 날짜

    private User() {
    }

    public User(String userId, String password, LocalDateTime createDate) {
        this.userId = userId;
        this.password = password;
        this.createDate = createDate;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
