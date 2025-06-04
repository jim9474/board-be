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
}
