package com.kingbreak.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author li
 * @date 2021/9/12
 */
@Data
@ApiModel("登录")
public class LogInVo {

    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
}
