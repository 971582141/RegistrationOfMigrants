package com.kingbreak.controller;/**
 * @author lishaolong
 * @Date 2021/9/13
 */


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kingbreak.entity.SysRole;
import com.kingbreak.entity.SysRouterRole;
import com.kingbreak.model.PageObject;
import com.kingbreak.model.Result;
import com.kingbreak.service.SysRoleService;
import com.kingbreak.service.SysRouterRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author li
 * @date 2021/9/13
 */
@RestController
@RequestMapping("sysRole")
@Api(tags = "系统角色", value = "SysRoleController")
public class SysRoleController {

    @Autowired
    private SysRoleService service;
    @Autowired
    private SysRouterRoleService sysRouterRole;

    @PostMapping("sysRolePage")
    @ApiOperation("系统角色列表")
    public Result<IPage<SysRole>> sysRolePage(@RequestBody PageObject<SysRole> pageObject) {
        return Result.ok(service.sysRolePage(pageObject));
    }

    @PostMapping("addSysRole")
    @ApiOperation("添加角色")
    public Result addSysRole(@RequestBody SysRole sysRole) {
        return Result.ok(service.save(sysRole));
    }

    @PostMapping("updateSysRole")
    @ApiOperation("修改角色")
    public Result updateSysRole(@RequestBody SysRole sysRole) {
        return Result.ok(service.updateById(sysRole));
    }

    @PostMapping("deleteSysRoleById")
    @ApiOperation("删除角色")
    public Result deleteSysRoleById(@RequestBody String id) {
        sysRouterRole.remove(new QueryWrapper<SysRouterRole>().eq("role_id", id));
        return Result.ok(service.removeById(id));
    }

    @GetMapping("get")
    public Result get() {
        return Result.ok("helloword");
    }
}
