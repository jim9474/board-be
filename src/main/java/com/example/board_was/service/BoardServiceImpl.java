package com.example.board_was.service;

import com.example.board_was.mapper.BoardMapper;
import com.example.board_was.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    @Autowired
    private final BoardMapper boardMapper;

    @Override
    public void addReadCnt(int boardId) {
        boardMapper.addReadCnt(boardId);
    }

    @Override
    public void createBoard(Map<String, String> request) {
        Board board = new Board();
        try {
            board.setBoardTitle(request.get("boardTitle"));
            board.setBoardDivCd(request.get("boardDivCd"));
            board.setBoardText(request.get("boardText"));
            boardMapper.createBoard(board);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteBoard(int boardId) {
        boardMapper.deleteBoard(boardId);
    }
}
