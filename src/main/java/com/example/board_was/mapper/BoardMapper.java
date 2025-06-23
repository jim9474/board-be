package com.example.board_was.mapper;

import com.example.board_was.model.Board;
import com.example.board_was.model.Comment;

import java.util.List;

public interface BoardMapper {
    List<Board> findAll();
    void addReadCnt(int boardId);

    void createBoard(Board board);

    Board getBoardDetail(int boardId);

    int deleteBoard(int boardId);

    List<Board> findGameAll();

    List<Board> findStreamingAll();

    List<Board> findPoliticsAll();

    List<Board> findSportsAll();

    void regComment(Comment comment);

    List<Comment> getCommentList(int boardId);

    void deleteBoardComment(int boardId);

    void deleteComment(Comment comment);

    void createReplyComment(Comment comment);
}
