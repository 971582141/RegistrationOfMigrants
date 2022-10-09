package com.kingbreak.model;


import com.kingbreak.enumer.ResultEnum;
import com.kingbreak.exception.DefinitionException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "返回格式")
public class Result<T> {
    /**
     * 错误码.
     */
    @ApiModelProperty(value = "code")
    private Integer code;

    /**
     * 提示信息.
     */
    @ApiModelProperty(value = "说明")
    private String msg;

    /**
     * 具体的内容.
     */
    @ApiModelProperty(value = "返回数据")
    private T data;

    public static Result ok(Object object) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("ok");
        result.setData(object);
        return result;
    }

    public static Result ok() {
        return ok(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(ResultEnum resultEnum, Exception e) {
        Result result = new Result();
        result.setMsg(resultEnum.getMsg());
        result.setCode(resultEnum.getCode());
        result.setData(e);
        return result;
    }

    /**
     * 自定义异常返回的结果
     */
    public static Result defineError(DefinitionException de) {
        return error(de.getErrorCode(), de.getErrorMessage());
    }

    /**
     * 其他异常处理方法返回的结果
     */
    public static Result otherError(ResultEnum resultEnum, Exception e) {
        Result result = new Result();
        result.setMsg(resultEnum.getMsg());
        result.setCode(resultEnum.getCode());
        result.setData(e);
        return result;
    }


}