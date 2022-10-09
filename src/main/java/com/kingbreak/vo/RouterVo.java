package com.kingbreak.vo;/**
 * @author lishaolong
 * @Date 2021/9/13
 */

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author li
 * @date 2021/9/13
 */
@Data
@ApiModel("路由视图")
public class RouterVo {

    @ApiModelProperty(value = "自增主键id")
    private Integer id;
    @ApiModelProperty(value = "中文名称")
    private String name;
    @ApiModelProperty(value = "对应的url")
    private String url;
    @ApiModelProperty(value = "父id")
    private Integer pid;
    @ApiModelProperty(value = "层级")
    private Integer level;
    @ApiModelProperty(value = "顺序")
    private Integer Sort;
    @ApiModelProperty(value = "类型：1.菜单 2.页面 3.按钮")
    private Integer type;
    @ApiModelProperty(value = "图标")
    private String icon;
    @ApiModelProperty(value = "是否有权限")
    @TableField(exist = false)
    private Boolean isUse;
    private List<RouterVo> children;

}
