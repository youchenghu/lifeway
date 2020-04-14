package com.hyc.lifeway.common.interceptor;

import com.hyc.cs.core.web.api.ApiHeader;
import com.hyc.cs.core.web.api.ApiHeaderParser;
import com.hyc.lifeway.common.WebApiContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: hyc
 * @Date: 2019-12-06
 * @Description: 拦截后台管理员的工号
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    ApiHeaderParser apiHeaderParser;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String adminJobNumber = apiHeaderParser.parseHeaderValue(request, ApiHeader.JobNumber);

        WebApiContext apiContext = WebApiContext.get();
        if (apiContext != null) {
            apiContext.setAdminJobNumber(adminJobNumber);
        }

        return super.preHandle(request, response, handler);
    }
}
