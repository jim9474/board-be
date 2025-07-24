package com.example.board_was.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class BoardVote {
    private int vote_id;
    private int board_id;
    private String user_id;
    private String vote_type;
    
    private int upCnt;
    private int downCnt;

    public void setBoardId(Object boardId) {
        this.board_id = (int) boardId;
    }
    public void setUserId(Object userId) {
        this.user_id = (String) userId;
    }
    public void setVoteType(Object voteType) {
        this.vote_type = (String) voteType;
    }

    public Object getVoteType() {
        return vote_type;
    }
}
