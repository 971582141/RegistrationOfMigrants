package com.kingbreak.util;


import com.kingbreak.entity.SysUser;
import com.kingbreak.mapper.SysUserMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author li
 * @date 2021/9/12
 */
public class JwtUtil {


    @Autowired
    private SysUserMapper sysUserMapper;

    public static final String SUBJECT = "Genius";

    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;  //过期时间，毫秒，一周

    //秘钥
    public static final String APPSECRET = "youAreAGenius";

    /**
     * 生成jwt
     *
     * @param user
     * @return
     */
    public static String geneJsonWebToken(SysUser user) {

        if (user == null || user.getId() == null || user.getUserName() == null) {
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim(SysUser.Fields.id, user.getId())
                .claim(SysUser.Fields.userName, user.getUserName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();

        return token;
    }


    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static boolean checkJWT(String token) {

        try {
            final Claims claims = Jwts.parser().setSigningKey(APPSECRET).
                    parseClaimsJws(token).getBody();
            return true;

        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 解析token获取用户
     *
     * @param token
     * @return
     */
    public static SysUser currentUser(String token) {
        Claims claims = Jwts.parser().setSigningKey(APPSECRET).
                parseClaimsJws(token).getBody();
        SysUser sysUser = new SysUser();
        sysUser.setUserName((String) claims.get(SysUser.Fields.userName));
        sysUser.setId((Integer) claims.get(SysUser.Fields.id));
        return sysUser;
    }


}
