package com.example.board_was.service;

import com.example.board_was.mapper.VoteMapper;
import com.example.board_was.model.BoardVote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService{
    private final VoteMapper voteMapper;

    @Override
    public BoardVote voteBoard(Map<String, Object> request) {
        BoardVote result = null;
        BoardVote boardVote = new BoardVote();
        try {
            boardVote.setBoardId(request.get("boardId"));
            boardVote.setUserId(request.get("userId"));
            boardVote.setVoteType(request.get("voteType"));
            result = voteMapper.voteBoard(boardVote);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public void createVote(Map<String, Object> request) {
        BoardVote boardVote = new BoardVote();
        try {
            boardVote.setBoardId(request.get("boardId"));
            boardVote.setUserId(request.get("userId"));
            boardVote.setVoteType(request.get("voteType"));
            voteMapper.createVote(boardVote);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateVote(Map<String, Object> request) {
        BoardVote boardVote = new BoardVote();
        try {
            boardVote.setBoardId(request.get("boardId"));
            boardVote.setUserId(request.get("userId"));
            boardVote.setVoteType(request.get("voteType"));
            voteMapper.updateVote(boardVote);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteVote(Map<String, Object> request) {
        BoardVote boardVote = new BoardVote();
        try {
            boardVote.setBoardId(request.get("boardId"));
            boardVote.setUserId(request.get("userId"));
            boardVote.setVoteType(request.get("voteType"));
            voteMapper.deleteVote(boardVote);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
