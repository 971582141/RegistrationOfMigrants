package com.kingbreak.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author li
 * @date 2021/9/12
 */
@Data
@ApiModel("登录返回对象")
public class LogInUserVo {

    @ApiModelProperty(value = "token")
    private String token;
    @ApiModelProperty(value = "菜单树")
    private List<RouterVo> routerVoList;
}
