package com.kingbreak.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Bean
    public MyWebMvcConfig getMyWebMvcConfig() {
        MyWebMvcConfig myWebMvcConfig = new MyWebMvcConfig() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("alogin");
//                registry.addViewController("/login").setViewName("alogin");
//                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器/inAndOutVehicles/inUpdate
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new HeaderTokenInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/login", "/", "/sysUser/login", "/sysRole/get", "/inAndOutVehicles/inUpdate", "/inAndOutVehicles/outUpdate"
                                , "/inVehicles/inUpdate", "/outVehicles/outUpdate", "/file/upload", "/vehicleInformation/addVehicleInformation", "/error")
                        .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**", "/doc.html");
            }

        };
        return myWebMvcConfig;
    }
}