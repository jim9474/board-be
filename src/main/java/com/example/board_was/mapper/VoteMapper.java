package com.example.board_was.mapper;

import com.example.board_was.model.BoardVote;

public interface VoteMapper {
    BoardVote voteBoard(BoardVote boardVote);

    void createVote(BoardVote boardVote);

    void updateVote(BoardVote boardVote);

    void deleteVote(BoardVote boardVote);

    String getVoteStatus(BoardVote boardVote);

    BoardVote getVoteCount(int boardId);
}
