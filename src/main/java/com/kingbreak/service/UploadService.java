package com.kingbreak.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.kingbreak.entity.SysUpload;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UploadService extends IService<SysUpload> {
    /**
     * 上传文件
     *
     * @param file
     * @param fileType
     */
    SysUpload uploadFile(MultipartFile file, String fileType);

    Integer fileList(List<MultipartFile> fileList);

    /**
     * 查看文件
     */
    void preview(String url, HttpServletResponse response) throws Exception;

    /**
     * 下载文件
     *
     * @param id
     * @param fileName
     */
    void downloadFile(Integer id, String fileName, HttpServletResponse response);

}
