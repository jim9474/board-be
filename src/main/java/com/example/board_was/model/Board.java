package com.example.board_was.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class Board {
    private int board_id;
    private String board_title;
    private String board_text;
    private int board_read_cnt;
    private String board_div_cd;
    private String crte_dtm;
    private String crte_user;
    private String mdfy_dtm;
    private String mdfy_user;

    public void setBoardTitle(String boardTitle) {
        this.board_title = boardTitle;
    }

    public void setBoardDivCd(String boardDivCd) {
        this.board_div_cd = boardDivCd;
    }

    public void setBoardText(String boardText) {
        this.board_text = boardText;
    }
}
