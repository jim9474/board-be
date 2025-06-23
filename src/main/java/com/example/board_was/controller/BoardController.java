package com.example.board_was.controller;

import com.example.board_was.mapper.BoardMapper;
import com.example.board_was.model.Board;
import com.example.board_was.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class BoardController {


    private final BoardMapper boardMapper;

    private final BoardService boardService;

    @ResponseBody
    @GetMapping("/getAllBoardList")
    public List<Board> getBoardList() {
        return boardMapper.findAll();
    }

    @ResponseBody
    @GetMapping("/getGameBoardList")
    public List<Board> getGameBoardList() {
        return boardMapper.findGameAll();
    }

    @ResponseBody
    @GetMapping("/getStreamingBoardList")
    public List<Board> getStreamingBoardList() {
        return boardMapper.findStreamingAll();
    }

    @ResponseBody
    @GetMapping("/getPoliticsBoardList")
    public List<Board> getPoliticsBoardList() {
        return boardMapper.findPoliticsAll();
    }

    @ResponseBody
    @GetMapping("/getSportsBoardList")
    public List<Board> getSportsBoardList() {
        return boardMapper.findSportsAll();
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

    @ResponseBody
    @PostMapping("/regComment")
    public void regComment(@RequestBody Map<String, Object> request) {
        System.out.println("regComment Controller Start..");
        boardService.regComment(request);
    }

    @ResponseBody
    @GetMapping("/getCommentList")
    public ResponseEntity<?> getCommentList(@RequestParam int boardId) {
        System.out.println("getCommentList Controller Start..");
        return ResponseEntity.ok(boardMapper.getCommentList(boardId));
    }

    @ResponseBody
    @PostMapping("/deleteComment")
    public void deleteComment(@RequestBody Map<String, Object> request) {
        System.out.println("deleteComment Controller Start..");
        boardService.deleteComment(request);
    }

//    @ResponseBody
//    @PostMapping("/createReplyComment")
//    public void createReplyComment(@RequestBody Map<String, Object> request) {
//        System.out.println("createReplyComment Controller Start..");
//        boardService.createReplyComment(request);
//    }
}
