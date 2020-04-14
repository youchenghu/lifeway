package com.hyc.lifeway.module.user.service;

import com.hyc.lifeway.module.user.model.User;
import com.hyc.cs.core.common.BaseService;

/**
 * @Author: MyBatis Plus Generator
 * @Date: 2020-04-08
 * @Description:
 */
public interface UserService extends BaseService<User> {

    /**
     * 根据token获取user
     * @param token
     * @return
     */
    User getByToken(String token);
}
