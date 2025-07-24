package com.example.board_was.controller;

import com.example.board_was.mapper.VoteMapper;
import com.example.board_was.model.BoardVote;
import com.example.board_was.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;
    private final VoteMapper voteMapper;


    @PostMapping("/voteBoard")
    @ResponseBody
    public void voteBoard(@RequestBody Map<String, Object> request) {
        System.out.println("voteBoard Controller Start..");

        BoardVote isVote = voteService.voteBoard(request);
        if(isVote != null) {
            String voteType = (String) isVote.getVoteType();
            if(Objects.equals(request.get("voteType"), voteType)) {
                voteService.deleteVote(request);
            } else {
                voteService.updateVote(request);
            }
        } else {
            voteService.createVote(request);
        }
    }

    @GetMapping("/getVoteStatus")
    @ResponseBody
    public ResponseEntity<?> getVoteStatus(@RequestParam int boardId, String userId) {
        System.out.println("getVoteStatus Controller Start..");

        // 현재 인증 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 유저 아이디 (username) 가져오기
        String userName = authentication.getName();
        System.out.println("userName >>> "+userName);

        BoardVote boardVote = new BoardVote();
        boardVote.setBoardId(boardId);
        boardVote.setUserId(userName);
        String result = voteMapper.getVoteStatus(boardVote);
        System.out.println("result >>> "+result);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getVoteCount")
    @ResponseBody
    public ResponseEntity<?> getVoteCount(@RequestParam int boardId) {
        System.out.println("getVoteCount Controller Start..");

        BoardVote result = voteMapper.getVoteCount(boardId);
        System.out.println("result >>> "+result);
        return ResponseEntity.ok(result);
    }
}
