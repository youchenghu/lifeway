package com.hyc.lifeway.common;

import com.hyc.cs.core.web.api.ApiContext;
import com.hyc.lifeway.module.user.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author ：胡友成
 * @Date ：2020/4/10 1:40 下午
 * @Description：请求上下文，每个请求线程生成一个，记录用户账号信息
 */
@Scope("prototype")
@Component
public class WebApiContext extends ApiContext {

    private User accessUser;

    private String adminJobNumber;

    public User getAccessUser() {
        return accessUser;
    }

    public void setAccessUser(User accessUser) {
        this.accessUser = accessUser;
    }

    public String getAdminJobNumber() {
        return adminJobNumber;
    }

    public void setAdminJobNumber(String adminJobNumber) {
        this.adminJobNumber = adminJobNumber;
    }
}
