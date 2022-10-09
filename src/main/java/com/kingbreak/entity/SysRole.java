package com.kingbreak.entity;/**
 * @author lishaolong
 * @Date 2021/9/9
 */

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.util.Date;

/**
 * @author li
 * @date 2021/9/9
 */
@Data
@ApiModel("角色表")
@FieldNameConstants
@TableName(value = "sys_role")
public class SysRole {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("角色id")
    private Integer Id;
    @ApiModelProperty("角色名称")
    private String roleName;
    @ApiModelProperty("角色说明")
    private String roleDetail;
    @ApiModelProperty("是否使用")
    private Integer isUse;
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private Date createDate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty("修改时间")
    private Date updateDate;
}
