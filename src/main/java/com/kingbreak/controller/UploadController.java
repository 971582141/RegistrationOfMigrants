package com.kingbreak.controller;

import com.kingbreak.entity.SysUpload;
import com.kingbreak.enumer.ResultEnum;
import com.kingbreak.exception.DefinitionException;
import com.kingbreak.model.Result;
import com.kingbreak.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Api(tags = "上传模块-上传模块")
@RequestMapping("file")
public class UploadController {

    @Autowired
    private UploadService sysUploadService;


    @PostMapping("upload")
    @ApiOperation(value = "上传文件")
    public Result<SysUpload> file(MultipartFile avatar, String fileType) {
        if (avatar == null || StringUtils.isBlank(fileType)) {
            throw new DefinitionException(ResultEnum.FILE_NULL);
        }
        return Result.ok(sysUploadService.uploadFile(avatar, fileType));
    }

    @PostMapping("fileList")
    @ApiOperation(value = "批量上传图片")
    public Result fileList(@RequestParam("avatarList") List<MultipartFile> avatarList) {
        return Result.ok(sysUploadService.fileList(avatarList));
    }


    @GetMapping("preview")
    @ApiOperation(value = "查看文件")
    public void preview(String url, HttpServletResponse response) throws Exception {
        sysUploadService.preview(url, response);
    }

    @GetMapping("down")
    @ApiOperation(value = "下载文件")
    public void downloadFile(Integer uploadId, String fileName,
                             HttpServletResponse response) {
        if (uploadId == null || StringUtils.isBlank(fileName)) {
            throw new DefinitionException(ResultEnum.FILE_NOT_VIEW);
        }
        sysUploadService.downloadFile(uploadId, fileName, response);
    }
}
