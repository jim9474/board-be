package com.example.board_was.controller;

import com.example.board_was.mapper.BoardMapper;
import com.example.board_was.model.Board;
import com.example.board_was.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private final BoardMapper boardMapper;
    @Autowired
    private final BoardService boardService;

    @ResponseBody
    @GetMapping("/getBoardList")
    public List<Board> getBoardList() {
        return boardMapper.findAll();
    }

    @ResponseBody
    @PostMapping("/addReadCnt")
    public void addReadCnt(@RequestBody Map<String, Integer> request) {
        int boardId = request.get("boardId");
        System.out.println("addReadCnt Controller Start..");
        System.out.println("boardId >>> " + boardId);
        boardService.addReadCnt(boardId);
    }

    @ResponseBody
    @PostMapping("/createBoard")
    public void createBoard(@RequestBody Map<String, String> request) {
        System.out.println("createBoard Controller Start..");
        boardService.createBoard(request);
    }

    @ResponseBody
    @GetMapping("/getBoardDetail")
    public Board getBoardDetail(@RequestParam int boardId) {
        System.out.println("getBoardDetail Controller Start..");
        System.out.println("boardId >>> " + boardId);
        return boardMapper.getBoardDetail(boardId);
    }

    @ResponseBody
    @PostMapping("/deleteBoard")
    public void deleteBoard(@RequestBody Map<String,Integer> request) {
        System.out.println("deleteBoard Controller Start..");
        int boardId = request.get("id");
        boardService.deleteBoard(boardId);
    }
}
