package com.kingbreak.interceptor;



import com.kingbreak.enumer.ResultEnum;
import com.kingbreak.exception.DefinitionException;
import com.kingbreak.util.JwtUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Configuration
public class HeaderTokenInterceptor implements HandlerInterceptor {


    //第一个函数preHandle是预处理函数,比如我们用于拦截登录时,它是第一个工作的。
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o) throws Exception {


        System.out.println(httpServletRequest.getRequestURI());
        if (!httpServletRequest.getRequestURI().contains("login")) {
            if (httpServletRequest.getHeader("authorization") == null) {
                throw new DefinitionException(ResultEnum.TOKEN_NOT_NULL);
            } else if (!JwtUtil.checkJWT(httpServletRequest.getHeader("authorization"))) {
                throw new DefinitionException(ResultEnum.TOKEN_INVALIDATION);
            }
        }

        return true;
    }

    //当请求到达Controller但是未渲染View时进行处理
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object
            o, ModelAndView modelAndView) {

    }

    //相当于最后的回调函数
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, Object o, Exception e) {

    }
}
