package com.example.demobook.user.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @Column(name = "user_id")
    private String userId; //유저 ID
    private String password; //비밀 번호
    private LocalDateTime createDate; //생성 날짜
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST) //연관되어 매핑된 UserInfo 정의된 객체
    private List<UserAuthorization> userAuthorizations = new ArrayList<>();

    private User() {
    }

    public User(String userId, String password, LocalDateTime createDate) {
        this.userId = userId;
        this.password = password;
        this.createDate = createDate;
    }

    public void addUserAuthorization(UserAuthorization userAuthorization) {
        //무한 루프에 빠지는 거 방지
        if(userAuthorization == null) {
            userAuthorizations = new ArrayList<>();
        }
        userAuthorizations.add(userAuthorization);
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public List<UserAuthorization> getUserAuthorizations() {
        return userAuthorizations;
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
