package com.example.board_was.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class File {
    private String attach_file_id;
    private String attach_file_nm;
    private String attach_file_path;
    private long attach_file_size;
    private String crte_user;
    private String crte_dtm;
    private String attach_file_gr_id;

    public void setAttach_file_id(String fileId) {
        this.attach_file_id = fileId;
    }
    public void setAttach_file_nm(String fileNm) {
        this.attach_file_nm = fileNm;
    }
    public void setAttach_file_path(String filePath) {
        this.attach_file_path = filePath;
    }
    public void setAttach_file_size(long fileSize) {
        this.attach_file_size = fileSize;
    }
    public void setCrte_user(String userId) {
        this.crte_user = userId;
    }
    public void setAttach_file_gr_id(String fileGrId) {
        this.attach_file_gr_id = fileGrId;
    }
}
