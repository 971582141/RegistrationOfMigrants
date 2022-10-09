package com.kingbreak.service;/**
 * @author lishaolong
 * @Date 2021/9/9
 */


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kingbreak.entity.SysUser;
import com.kingbreak.model.PageObject;
import com.kingbreak.vo.LogInUserVo;


/**
 * @author li
 * @date 2021/9/9
 */
public interface SysUserService extends IService<SysUser> {

    LogInUserVo logIn(SysUser sysUser);

    IPage<SysUser> userList(PageObject<SysUser> pageObject);
}
