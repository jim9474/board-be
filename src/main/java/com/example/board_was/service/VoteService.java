package com.example.board_was.service;

import com.example.board_was.model.BoardVote;

import java.util.Map;

public interface VoteService {
    BoardVote voteBoard(Map<String, Object> request);

    void createVote(Map<String, Object> request);

    void updateVote(Map<String, Object> request);

    void deleteVote(Map<String, Object> request);
}
