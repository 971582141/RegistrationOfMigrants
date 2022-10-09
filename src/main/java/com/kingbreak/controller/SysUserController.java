package com.kingbreak.controller;/**
 * @author lishaolong
 * @Date 2021/9/9
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kingbreak.entity.SysUser;
import com.kingbreak.model.PageObject;
import com.kingbreak.model.Result;
import com.kingbreak.service.SysUserService;
import com.kingbreak.vo.LogInUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author li
 * @date 2021/9/9
 */
@RestController
@RequestMapping("sysUser")
@Api(tags = "系统用户", value = "SysUserController")
public class SysUserController {
    @Autowired
    SysUserService service;

    @PostMapping("login")
    @ApiOperation("登录")
    public Result<LogInUserVo> logIn(@RequestBody SysUser user) {
        return Result.ok(service.logIn(user));
    }

    @PostMapping("addSysUser")
    @ApiOperation("添加用户")
    public Result addSysUser(@RequestBody SysUser sysUser) {
        return Result.ok(service.save(sysUser));
    }

    @PostMapping("updateSysUser")
    @ApiOperation("编辑用户")
    public Result updateSysUser(@RequestBody SysUser sysUser) {
        return Result.ok(service.updateById(sysUser));
    }

    @PostMapping("userList")
    @ApiOperation("分页查询用户")
    public Result<IPage<SysUser>> userList(@RequestBody PageObject<SysUser> page) {
        return Result.ok(service.userList(page));
    }
}
