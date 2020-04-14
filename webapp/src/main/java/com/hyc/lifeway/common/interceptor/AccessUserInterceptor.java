package com.hyc.lifeway.common.interceptor;

import com.hyc.cs.core.web.api.ApiHeader;
import com.hyc.cs.core.web.api.ApiHeaderParser;
import com.hyc.lifeway.common.WebApiContext;
import com.hyc.lifeway.module.user.model.User;
import com.hyc.lifeway.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author ：胡友成
 * @Date ：2020/4/10 1:43 下午
 * @Description：截获用户的token，找出account放进WebApiContext
 */
public class AccessUserInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    UserService userService;

    @Autowired
    ApiHeaderParser apiHeaderParser;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 截获用户token并设置进请求上下文
        User account = getUserByToken(request);

        if (account != null) {
            WebApiContext apiContext = WebApiContext.get();
            if (apiContext != null) {
                apiContext.setAccessUser(account);
            }
        }

        return super.preHandle(request, response, handler);
    }

    private User getUserByToken(HttpServletRequest request) {

        String storeToken = apiHeaderParser.parseHeaderValue(request, ApiHeader.UserToken);
        return userService.getByToken(storeToken);
    }
}
