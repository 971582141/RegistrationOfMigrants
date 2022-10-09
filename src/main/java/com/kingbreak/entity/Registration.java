package com.kingbreak.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.util.Date;

/**
 * @author lishaolong
 * @Date 2022/10/9
 */
@Data
@ApiModel("外来人员登记表")
@FieldNameConstants
@TableName(value = "registration")
public class Registration {

    @ApiModelProperty(value = "自增主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    @ApiModelProperty("地址id")
    private String addressId;
    @ApiModelProperty("登记地址 高速口地址")
    private String registrationAddress;
    @ApiModelProperty("姓名")
    private String name;
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    @ApiModelProperty("出发地")
    private String origin;
    @ApiModelProperty("事由")
    private String reason;
    @ApiModelProperty("健康码截图")
    private String healthFileUrl;
    @ApiModelProperty("健康码类型")
    private String healthType;
    @ApiModelProperty("行程码截图")
    private String tripFileUrl;
    @ApiModelProperty("行程")
    private String trip;
    @ApiModelProperty("身份证")
    private String IdCard;
    @ApiModelProperty("联系电话")
    private String phone;

}
