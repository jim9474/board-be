package com.example.board_was.service;

import java.util.Map;

public interface BoardService {
    void addReadCnt(int boardId);

    void createBoard(Map<String, String> request);

    void deleteBoard(int boardId);

    void regComment(Map<String, Object> request);

    void deleteComment(Map<String, Object> request);

    void createReplyComment(Map<String, Object> request);
}
