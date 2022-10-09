package com.kingbreak.controller;/**
 * @author lishaolong
 * @Date 2021/9/13
 */


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kingbreak.entity.SysRouterRole;
import com.kingbreak.model.Result;
import com.kingbreak.service.SysRouterRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author li
 * @date 2021/9/13
 */
@RestController
@RequestMapping("sysRouterRole")
@Api(tags = "角色路由对应", value = "SysRouterRoleController")
public class SysRouterRoleController {

    @Autowired
    private SysRouterRoleService service;

//    @PostMapping("addSysRouterRole")
//    @ApiOperation("添加角色路由")
//    public Result addSysRouterRole(@RequestBody SysRouterRole sysRouterRole) {
//        return Result.ok(service.save(sysRouterRole));
//    }

    @PostMapping("addSysRouterRoleList")
    @ApiOperation("批量添加角色路由")
    public Result addSysRouterRoleList(@RequestBody List<SysRouterRole> sysRouterRoleList) {
        if (sysRouterRoleList != null) {
            service.remove(new QueryWrapper<SysRouterRole>().eq("role_id", sysRouterRoleList.get(0).getRoleId()));
        }
        return Result.ok(service.saveBatch(sysRouterRoleList));
    }

    @PostMapping("sysRouterRoleListByRoleId")
    @ApiOperation("查看角色路由")
    public Result sysRouterRoleListByRoleId(@RequestBody Integer roleId) {
        return Result.ok(service.list(new QueryWrapper<SysRouterRole>().eq("role_id", roleId)));
    }

}
