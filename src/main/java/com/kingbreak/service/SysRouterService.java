package com.kingbreak.service;/**
 * @author lishaolong
 * @Date 2021/9/12
 */


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kingbreak.entity.SysRouter;
import com.kingbreak.model.PageObject;
import com.kingbreak.vo.RouterVo;


import java.util.List;

/**
 * @author li
 * @date 2021/9/12
 */
public interface SysRouterService extends IService<SysRouter> {

    List<RouterVo> allRouterVoTree();

    List<RouterVo> allRouterVoByRoleId(Integer roleId);

    IPage<SysRouter> routerList(PageObject<SysRouter> pageObject);

    List<RouterVo> routerVoUpdateList(Integer roleId);

}
