package com.kingbreak.mapper;/**
 * @author lishaolong
 * @Date 2021/9/12
 */


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kingbreak.entity.SysRouter;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author li
 * @date 2021/9/12
 */

public interface SysRouterMapper extends BaseMapper<SysRouter> {

    @Select("select a.id,\n" +
            "       code,\n" +
            "       name,\n" +
            "       url,\n" +
            "       p_id,\n" +
            "       level,\n" +
            "       sort,\n" +
            "       type,\n" +
            "       jump,\n" +
            "       a.create_date,\n" +
            "       update_date,icon\n" +
            "from sys_router as a\n" +
            "         left join sys_router_role as b on a.id = b.router_id\n" +
            "where type = 1\n" +
            "  and b.role_id = #{roleId}")
    List<SysRouter> sysRoutersByRoleId(Integer roleId);

    @Select("select a.id,\n" +
            "       code,\n" +
            "       name,\n" +
            "       url,\n" +
            "       p_id,\n" +
            "       level,\n" +
            "       sort,\n" +
            "       type,\n" +
            "       jump,\n" +
            "       a.create_date,\n" +
            "       update_date,icon\n" +
            "from sys_router as a\n" +
            "         left join sys_router_role as b on a.id = b.router_id\n" +
            "where type = 2\n" +
            "  and b.role_id = #{roleId}")
    List<SysRouter> pageListByRoleId(Integer roleId);

    @Select("select a.id,\n" +
            "       code,\n" +
            "       name,\n" +
            "       url,\n" +
            "       p_id,\n" +
            "       level,\n" +
            "       sort,\n" +
            "       type,\n" +
            "       jump,\n" +
            "       a.create_date,\n" +
            "       update_date,icon\n" +
            "from sys_router as a\n" +
            "         left join sys_router_role as b on a.id = b.router_id\n" +
            "where type = 3\n" +
            "  and b.role_id = #{roleId}")
    List<SysRouter> actionListByRoleId(Integer roleId);
}
