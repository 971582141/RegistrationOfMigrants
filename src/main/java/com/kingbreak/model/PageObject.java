package com.kingbreak.model;/**
 * @author lishaolong
 * @Date 2021/9/13
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author li
 * @date 2021/9/13
 */
@Data
@ApiModel("分页入参")
public class PageObject<T> {

    @ApiModelProperty("分页大小")
    private long size;
    @ApiModelProperty("当前页数")
    private long current;
    @ApiModelProperty("分页入参")
    private T data;
}
