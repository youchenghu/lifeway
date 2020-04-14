package com.hyc.lifeway.module.user.service.impl;

import com.google.common.util.concurrent.AtomicDouble;
import com.hyc.lifeway.module.user.model.User;
import com.hyc.lifeway.module.user.dao.UserDao;
import com.hyc.lifeway.module.user.service.UserService;
import com.hyc.cs.core.common.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Author: MyBatis Plus Generator
 * @Date: 2020-04-08
 * @Description:
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, User> implements UserService {

    @Override
    public User getByToken(String token) {

        // todo
        return null;
    }
}
