package com.example.board_was.service;

import com.example.board_was.mapper.BoardMapper;
import com.example.board_was.mapper.UserMapper;
import com.example.board_was.model.Board;
import com.example.board_was.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardMapper boardMapper;
    private final UserMapper userMapper;

    @Override
    public void addReadCnt(int boardId) {
        boardMapper.addReadCnt(boardId);
    }

    @Override
    public void createBoard(Map<String, String> request) {
        // 현재 인증 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 유저 아이디 (username) 가져오기
        String username = authentication.getName();
        Board board = new Board();
        try {
            board.setBoardTitle(request.get("boardTitle"));
            board.setBoardDivCd(request.get("boardDivCd"));
            board.setBoardText(request.get("boardText"));
            board.setCrteUser(username);
            boardMapper.createBoard(board);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteBoard(int boardId) {
        int result = boardMapper.deleteBoard(boardId);
        if (result > 0) {
            boardMapper.deleteBoardComment(boardId);
        }
    }

    @Override
    public void regComment(Map<String, Object> request) {
        // 현재 인증 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 유저 아이디 (username) 가져오기
        String username = authentication.getName();
        Comment comment = new Comment();

        String userNn = userMapper.getUserNn(username);
        try {
            comment.setBoardId(request.get("board_id"));
            comment.setContent(request.get("content"));
            comment.setUserNn(userNn);
            comment.setParentId(request.get("parent_id"));
            comment.setCrteUser(username);
            comment.setCommentStCd(request.get("comment_st_cd"));
            boardMapper.regComment(comment);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteComment(Map<String, Object> request) {
        // 현재 인증 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 유저 아이디 (username) 가져오기
        String userId = authentication.getName();
        Comment comment = new Comment();

        try {
            comment.setCommentId(request.get("id"));
            comment.setCrteUser(userId);
            boardMapper.deleteComment(comment);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createReplyComment(Map<String, Object> request) {
        // 현재 인증 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 유저 아이디 (username) 가져오기
        String userId = authentication.getName();
        Comment comment = new Comment();

        try {
            comment.setContent(request.get("content"));
            comment.setUserNn((String) request.get("userNn"));
            comment.setCrteUser(userId);
            comment.setParentId(request.get("parentId"));
            comment.setBoardId(request.get("boardId"));
            boardMapper.createReplyComment(comment);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
