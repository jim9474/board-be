package com.example.board_was.controller;

import com.example.board_was.mapper.FileMapper;
import com.example.board_was.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;
    private final FileMapper fileMapper;

    @PostMapping("/uploadFile")
    @ResponseBody
    public ResponseEntity<?> uploadFile(@RequestParam("files") List<MultipartFile> files) {
        System.out.println("uploadFile Controller Start..");
//        System.out.println("fileInfo >>> "+file);
//        System.out.println("파일 이름: " + file.getOriginalFilename());
//        System.out.println("파일 크기: " + file.getSize() + " bytes");
//        System.out.println("Content-Type: " + file.getContentType());

        String fileGrId = UUID.randomUUID().toString();
        for (MultipartFile file : files) {
            fileService.saveFile(file, fileGrId);
        }

        return ResponseEntity.ok(fileGrId);
    }
}
