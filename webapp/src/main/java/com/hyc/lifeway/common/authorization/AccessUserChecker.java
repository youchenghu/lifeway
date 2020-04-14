package com.hyc.lifeway.common.authorization;

import com.hyc.cs.core.security.AuthorizationChecker;
import com.hyc.lifeway.common.WebApiContext;
import com.hyc.lifeway.module.user.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ：胡友成
 * @Date ：2020/4/10 1:39 下午
 * @Description：
 */
public class AccessUserChecker implements AuthorizationChecker {

    AccessUserChecker(){
    }

    @Override
    public boolean check(HttpServletRequest request) {
        WebApiContext apiContext = WebApiContext.get();
        if (apiContext != null) {
            User accessUser = apiContext.getAccessUser();
            if (accessUser != null) {
                return true;
            }
        }
        return false;
    }
}
