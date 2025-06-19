package com.example.board_was.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class Comment {

    private int comment_id;
    private int board_id;
    private String content;
    private String user_nn;
    private String crte_dtm;
    private int parent_id;


    public void setBoardId(Object boardId) {
        this.board_id = (int) boardId;
    }

    public void setContent(Object content) {
        this.content = (String) content;
    }

    public void setUserNn(String userNn) {
        this.user_nn = userNn;
    }

    public void setParentId(Object parentId) {
        this.parent_id = (int) parentId;
    }
}
