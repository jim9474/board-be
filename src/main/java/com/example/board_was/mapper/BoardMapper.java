package com.example.board_was.mapper;

import com.example.board_was.model.Board;
import com.example.board_was.model.Comment;

import java.util.List;

public interface BoardMapper {
    List<Board> findAll();
    void addReadCnt(int boardId);

    void createBoard(Board board);

    Board getBoardDetail(int boardId);

    void deleteBoard(int boardId);

    List<Board> findGameAll();

    List<Board> findStreamingAll();

    List<Board> findPoliticsAll();

    List<Board> findSportsAll();

    void regComment(Comment comment);

    List<Comment> getCommentList(int boardId);
}
