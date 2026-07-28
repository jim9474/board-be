package com.example.board_was.service;

import com.example.board_was.mapper.FileMapper;
import com.example.board_was.model.File;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{
    @Value("${file.upload-dir}")
    private String uploadDir;

    private final FileMapper fileMapper;

    @Override
    public void saveFile(MultipartFile file, String fileGrId) {
        String fileId = null;
        File reqMap = new File();

        // 현재 인증 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 유저 아이디 (username) 가져오기
        String userName = authentication.getName();
        System.out.println("userName >>> "+userName);
        try {
            fileId = UUID.randomUUID().toString();
            Path uploadPath = Paths.get(uploadDir);
            System.out.println("파일 이름: "+file.getOriginalFilename());
            System.out.println("업로드 경로: "+uploadPath);
            System.out.println("파일 크기: " + file.getSize());

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(file.getOriginalFilename());
            System.out.println("파일 경로: "+filePath);
            reqMap.setAttach_file_id(fileId);
            reqMap.setAttach_file_nm(file.getOriginalFilename());
            reqMap.setAttach_file_path(filePath.toString());
            reqMap.setAttach_file_size(file.getSize());
            reqMap.setCrte_user(userName);
            reqMap.setAttach_file_gr_id(fileGrId);
            fileMapper.saveFile(reqMap);

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
