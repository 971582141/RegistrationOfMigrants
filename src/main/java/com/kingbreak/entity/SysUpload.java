package com.kingbreak.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "上传文件")
@TableName("sys_upload")
public class SysUpload {

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 文件名称
     */
    @ApiModelProperty(value = "文件名称")
    private String fileName;
    /**
     * 文件类型
     */
    @ApiModelProperty(value = "文件类型")
    private String fileType;
    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径")
    private String filePath;

    /**
     * 文件真实地址
     */
    @ApiModelProperty(value = "文件真实地址")
    private String fileRealPath;
    @ApiModelProperty(value = "生成时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
}