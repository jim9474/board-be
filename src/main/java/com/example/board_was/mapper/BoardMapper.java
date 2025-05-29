package com.example.board_was.mapper;

import com.example.board_was.model.Board;

import java.util.List;

public interface BoardMapper {
    List<Board> findAll();
    void addReadCnt(int boardId);

    void createBoard(Board board);

    Board getBoardDetail(int boardId);

    void deleteBoard(int boardId);
}
