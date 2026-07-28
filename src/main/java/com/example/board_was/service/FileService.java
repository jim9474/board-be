package com.example.board_was.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void saveFile(MultipartFile file, String fileGrId);
}
