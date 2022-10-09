package com.kingbreak.service.impl;/**
 * @author lishaolong
 * @Date 2021/9/13
 */


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kingbreak.entity.SysRouter;
import com.kingbreak.entity.SysRouterRole;
import com.kingbreak.mapper.SysRouterMapper;
import com.kingbreak.model.PageObject;
import com.kingbreak.service.SysRouterRoleService;
import com.kingbreak.service.SysRouterService;
import com.kingbreak.vo.RouterVo;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @date 2021/9/13
 */
@Service
public class SysRouterServiceImpl extends ServiceImpl<SysRouterMapper, SysRouter>
        implements SysRouterService {

    @Autowired
    Mapper mapper;
    @Autowired
    SysRouterRoleService sysRouterRoleServiceService;

    @Override
    public List<RouterVo> allRouterVoTree() {
        List<SysRouter> routerList = list(new QueryWrapper<>());
        //全部菜单
        List<RouterVo> menuRouter = new ArrayList<>();
        routerList.forEach(sysRouter -> menuRouter.add(mapper.map(sysRouter, RouterVo.class)));
        //最上级
        List<RouterVo> rootList = new ArrayList<>();
        List<RouterVo> result = new ArrayList<>();
        //拿到最上级
        menuRouter.forEach(menuNode -> {
            if (menuNode.getLevel() == 0) {
                rootList.add(menuNode);
            }
        });
        rootList.forEach(routerVo -> {
            routerVo.setChildren(tree(menuRouter, routerVo.getId()));
            result.add(routerVo);
        });
        return result;
    }

    private List<RouterVo> tree(List<RouterVo> allRouterVo, Integer id) {
        List<RouterVo> result = new ArrayList<>();
        allRouterVo.forEach(routerVo -> {
            if (routerVo.getPid() != null) {
                if (routerVo.getPid().equals(id)) {
                    result.add(routerVo);
                }
            }
        });
        if (result.size() == 0) {
            return null;
        }
        for (RouterVo f : result) {
            f.setChildren(tree(allRouterVo, f.getId()));
        }
        return result;
    }


    @Override
    public List<RouterVo> allRouterVoByRoleId(Integer roleId) {
        //最上级
        List<RouterVo> rootList = new ArrayList<>();
        List<RouterVo> result = new ArrayList<>();
        List<RouterVo> routerVoList = new ArrayList<>();
        baseMapper.sysRoutersByRoleId(roleId).forEach(sysRouter ->
                routerVoList.add(mapper.map(sysRouter, RouterVo.class))
        );
        routerVoList.forEach(menuNode -> {
            if (menuNode.getLevel() == 0) {
                rootList.add(menuNode);
            }
        });
        rootList.forEach(routerVo -> {
            routerVo.setChildren(tree(routerVoList, routerVo.getId()));
            result.add(routerVo);
        });
        return result;
    }

    @Override
    public IPage<SysRouter> routerList(PageObject<SysRouter> pageObject) {
        Page page = new Page(pageObject.getCurrent(), pageObject.getSize());
        QueryWrapper<SysRouter> queryWrapper = new QueryWrapper<>();
        if (pageObject.getData() != null) {
            if (pageObject.getData().getLevel() != null) {
                queryWrapper.eq(SysRouter.Fields.level, pageObject.getData().getLevel());
            }
            if (pageObject.getData().getType() != null) {
                queryWrapper.eq(SysRouter.Fields.type, pageObject.getData().getType());
            }
            if (pageObject.getData().getName() != null) {
                queryWrapper.eq(SysRouter.Fields.name, pageObject.getData().getName());
            }
            if (pageObject.getData().getCode() != null) {
                queryWrapper.eq(SysRouter.Fields.code, pageObject.getData().getCode());
            }
            if (pageObject.getData().getUrl() != null) {
                queryWrapper.eq(SysRouter.Fields.url, pageObject.getData().getUrl());
            }
        }
        return baseMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<RouterVo> routerVoUpdateList(Integer roleId) {
        List<RouterVo> allRouters = new ArrayList<>();
        List<RouterVo> rootList = new ArrayList<>();
        List<RouterVo> resultList = new ArrayList<>();
        //角色权限
        List<SysRouterRole> sysRouterRoles = sysRouterRoleServiceService.sysRouterRoleListByRoleId(roleId);
        //全部路由
        List<SysRouter> routerList = baseMapper.selectList(new QueryWrapper<>());
        //转视图
        routerList.forEach(sysRouter -> {
            allRouters.add(mapper.map(sysRouter, RouterVo.class));
        });
        allRouters.forEach(routerVo -> {
            for (SysRouterRole sysRouterRole : sysRouterRoles) {
                if (routerVo.getId().equals(sysRouterRole.getRouterId())) {
                    routerVo.setIsUse(true);
                    break;
                }
            }
        });
        //取最上级
        allRouters.forEach(routerVo -> {
            if (routerVo.getLevel() == 0) {
                rootList.add(routerVo);
            }
        });
        //递归
        rootList.forEach(routerVo -> {
            routerVo.setChildren(tree(allRouters, routerVo.getId()));
            resultList.add(routerVo);
        });
        return resultList;
    }
}
