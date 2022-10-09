package com.kingbreak.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("文件视图")
public class UploadReturnVo {

    private String filePath;

    private String fileName;
}