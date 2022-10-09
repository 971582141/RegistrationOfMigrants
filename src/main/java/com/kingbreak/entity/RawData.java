package com.kingbreak.entity;/**
 * @author lishaolong
 * @Date 2021/12/8
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.util.Date;

/**
 * @author li
 * @date 2021/12/8
 */
@Data
@FieldNameConstants
@TableName(value = "raw_data")
@ApiModel(value = "回调报文")
public class RawData {

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @ApiModelProperty(value = "主键id")
    private String id;
    @ApiModelProperty(value = "报文")
    private String data;
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    @ApiModelProperty(value = "类型")
    private String type;
}
