package com.kingbreak.entity;/**
 * @author lishaolong
 * @Date 2021/9/10
 */

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
@FieldNameConstants
@ApiModel("角色路由映射表")
@TableName(value = "sys_router_role")
public class SysRouterRole {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "自增主键id")
    private Integer id;
    @ApiModelProperty(value = "路由id")
    private Integer routerId;
    @ApiModelProperty(value = "角色id")
    private Integer roleId;
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
}
