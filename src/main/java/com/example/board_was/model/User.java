package com.example.board_was.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class User {
    private String user_id;
    private String user_pw;
    private String user_email;
    private String user_nn;
    private String create_dtm;
    private String mdfy_dtm;

    public void setUserId(String userId) {
        this.user_id = userId;
    }

    public void setUserPw(String userPw) {
        this.user_pw = userPw;
    }

    public void setUserEmail(String userEmail) {
        this.user_email = userEmail;
    }

    public void setUserNn(String userNn) {
        this.user_nn = userNn;
    }

    public String getUserId() { return user_id; }

    public String getUserPw() { return user_pw; }

    public String getUserEmail() { return user_email; }

    public String getUserNn() { return user_nn; }
}
