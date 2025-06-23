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
    private String crte_user;
    private int comment_st_cd;

    public void setCommentId(Object commentId) {
        this.comment_id = (int) commentId;
    }

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

    public void setCrteUser(String userId) {
        this.crte_user = userId;
    }

    public void setCommentStCd(Object commentStCd) {
        this.comment_st_cd = (int) commentStCd;
    }

}
