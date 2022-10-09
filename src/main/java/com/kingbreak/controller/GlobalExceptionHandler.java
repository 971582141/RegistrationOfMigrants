package com.kingbreak.controller;//package com.core.controller;


import com.kingbreak.enumer.ResultEnum;
import com.kingbreak.exception.DefinitionException;
import com.kingbreak.model.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lishaolong
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(value = DefinitionException.class)
    @ResponseBody
    public Result bizExceptionHandler(DefinitionException e) {
        return Result.defineError(e);
    }
    /**
     * 处理自定义异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public Result nullExceptionHandler(NullPointerException e) {
        return Result.error(ResultEnum.NULL_POINTER_EXCEPTION,e);
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result otherExceptionHandler(Exception e) {
        return Result.otherError(ResultEnum.SYSTEM_ERROR, e);
    }
}

