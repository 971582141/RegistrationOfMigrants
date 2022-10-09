package com.kingbreak.enumer;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author li
 * @date 2021/9/12
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultEnum {
    LONGIN_ADMIN_ACCOUNT_CANNOT_BE_NULL(404, "账号不存在"),
    TOKEN_NOT_NULL(1400, "token为空"),
    TOKEN_INVALIDATION(1401, "token失效"),
    PASSWORD_MISTAKE(1405, "密码错误"),
    NULL_POINTER_EXCEPTION(1406, "对象空异常"),
    SYSTEM_ERROR(500, "系统错误"),
    FILE_NULL(1402, "文件不能为空"),
    FILE_NOT_VIEW(1403, "文件参数异常"),
    NUMBER_PLATE_REPEAT(1404, "车牌号重复"),
    MESSAGE_NULL(1405, "EventGpsCallBack报文数据为空"),
    ;

    private Integer code;
    private String msg;

}
