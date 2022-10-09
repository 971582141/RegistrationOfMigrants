package com.kingbreak.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kingbreak.entity.SysUser;
import com.kingbreak.enumer.ResultEnum;
import com.kingbreak.exception.DefinitionException;
import com.kingbreak.mapper.SysUserMapper;
import com.kingbreak.model.PageObject;
import com.kingbreak.service.SysRouterService;
import com.kingbreak.service.SysUserService;
import com.kingbreak.util.JwtUtil;
import com.kingbreak.vo.LogInUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author li
 * @date 2021/9/9
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    SysRouterService service;

    @Override
    public LogInUserVo logIn(SysUser sysUser) {
        SysUser user = baseMapper.selectOne(new QueryWrapper<SysUser>().
                eq("user_name", sysUser.getUserName()).
                eq("is_use", 1));
        if (user == null) {
            throw new DefinitionException(ResultEnum.LONGIN_ADMIN_ACCOUNT_CANNOT_BE_NULL);
        }
        if (!sysUser.getPassWord().equals(user.getPassWord())) {
            throw new DefinitionException(ResultEnum.PASSWORD_MISTAKE);
        }
        LogInUserVo userVo = new LogInUserVo();
        userVo.setRouterVoList(service.allRouterVoByRoleId(user.getRoleId()));
        userVo.setToken(JwtUtil.geneJsonWebToken(user));
        return userVo;
    }

    @Override
    public IPage<SysUser> userList(PageObject<SysUser> pageObject) {
        Page page = new Page(pageObject.getCurrent(), pageObject.getSize());
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper();
        if (pageObject.getData() != null) {
            if (pageObject.getData().getUserName() != null) {
                queryWrapper.eq("user_name", pageObject.getData().getUserName());
            }
            if (pageObject.getData().getRoleId() != null) {
                queryWrapper.eq("role_id", pageObject.getData().getRoleId());
            }
        }
        return baseMapper.selectPage(page, queryWrapper);
    }
}
