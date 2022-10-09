package com.kingbreak.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.util.Date;

/**
 * @author li
 * @date 2021/9/10
 */
@Data
@ApiModel("权限路由表")
@FieldNameConstants
@TableName(value = "sys_router")
public class SysRouter {

    @ApiModelProperty(value = "自增主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "代码")
    private String code;
    @ApiModelProperty(value = "中文名称")
    private String name;
    @ApiModelProperty(value = "对应的url")
    private String url;
    @ApiModelProperty(value = "父id")
    private Integer pId;
    @ApiModelProperty(value = "层级")
    private Integer level;
    @ApiModelProperty(value = "顺序")
    private Integer sort;
    @ApiModelProperty(value = "类型：1.菜单 2.页面 3.按钮")
    private String type;
    @ApiModelProperty(value = "重定向跳转")
    private String jump;
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改时间")
    private Date updateDate;
    @ApiModelProperty(value = "图标")
    private String icon;
}
