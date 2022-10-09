package com.kingbreak.service.impl;/**
 * @author lishaolong
 * @Date 2021/9/13
 */


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kingbreak.entity.SysRouterRole;
import com.kingbreak.mapper.SysRouterRoleMapper;
import com.kingbreak.service.SysRouterRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author li
 * @date 2021/9/13
 */
@Service
public class SysRouterRoleServiceImpl extends ServiceImpl<SysRouterRoleMapper, SysRouterRole> implements SysRouterRoleService {
    @Override
    public List<SysRouterRole> sysRouterRoleListByRoleId(Integer roleId) {
        QueryWrapper<SysRouterRole> queryWrapper = new QueryWrapper();
        queryWrapper.eq("role_id", roleId);
        return baseMapper.selectList(queryWrapper);
    }
}
