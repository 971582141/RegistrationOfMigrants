package com.kingbreak.exception;



import com.kingbreak.enumer.ResultEnum;
import lombok.Data;

/**
 * 自定义异常类
 *
 * @author
 */
@Data
public class DefinitionException extends RuntimeException {

    /**
     * 异常编号
     */
    private Integer errorCode;

    public DefinitionException(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public DefinitionException(ResultEnum resultEnum) {
        this.errorCode = resultEnum.getCode();
        this.errorMessage = resultEnum.getMsg();
    }

    /**
     * 异常信息
     */
    private String errorMessage;


}
