package com.hyc.lifeway.common.authorization;

import com.hyc.cs.core.security.AuthorizationChecker;
import com.hyc.cs.core.security.AuthorizationCheckerRegistry;
import com.hyc.cs.core.security.AuthorizationHandler;

/**
 * @Author ：胡友成
 * @Date ：2020/4/10 1:38 下午
 * @Description：每个@Authorization只能check一种Checker，省略Checker时默认用default
 */
public class WebAuthorizationHandler extends AuthorizationHandler {

    @Override
    protected Class<? extends AuthorizationChecker> defineDefaultCheckerClass() {
        return AccessUserChecker.class;
    }

    @Override
    protected void registerChecker(AuthorizationCheckerRegistry registry) {
        registry.addRegistry(new AccessUserChecker());
    }
}
