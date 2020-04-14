package com.hyc.lifeway.config;

import com.hyc.cs.core.security.AuthorizationHandler;
import com.hyc.cs.core.web.BaseWebConfiguration;
import com.hyc.lifeway.common.authorization.WebAuthorizationHandler;
import com.hyc.lifeway.common.interceptor.AccessUserInterceptor;
import com.hyc.lifeway.common.interceptor.AdminInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.util.List;

/**
 * @Author ：胡友成
 * @Date ：2020/4/10 12:12 下午
 * @Description：
 */
@Configuration
public class WebConfiguration extends BaseWebConfiguration {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);

        // 项目自定义的拦截器必须在super方法之后定义，因为可能会依赖父类中定义的拦截器
        registry.addInterceptor(accessUserInterceptor());
        registry.addInterceptor(adminInterceptor());

        // 有可能依赖用户的信息
        registry.addInterceptor(authorizationHandler());
    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);

        // 把返回值转换成xml
        converters.add(new StringHttpMessageConverter());
    }

    @Bean
    public AuthorizationHandler authorizationHandler() {
        return new WebAuthorizationHandler();
    }

    @Bean
    public AccessUserInterceptor accessUserInterceptor() {
        return new AccessUserInterceptor();
    }

    @Bean
    public AdminInterceptor adminInterceptor() {
        return new AdminInterceptor();
    }

}
