package com.hyc.lifeway.module.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hyc.lifeway.module.user.exception.UserNotFoundException;
import com.hyc.lifeway.module.user.model.User;
import com.hyc.lifeway.module.user.dao.UserDao;
import com.hyc.lifeway.module.user.service.UserService;
import com.hyc.cs.core.common.BaseServiceImpl;
import com.hyc.lifeway.module.user.service.impl.helper.AccessTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: MyBatis Plus Generator
 * @Date: 2020-04-08
 * @Description:
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, User> implements UserService {

    @Autowired
    AccessTokenHelper accessTokenHelper;

    @Override
    public User getByToken(String token) {
        Integer userId = accessTokenHelper.verify(token);
        return baseMapper.selectById(userId);
    }

    @Override
    public User getByPhone(String phone) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("phone", phone);
        return baseMapper.selectOne(qw);
    }

    @Override
    public String generateAccessToken(User user) {
        if(user == null){
            throw new UserNotFoundException();
        }
        return accessTokenHelper.generate(user.getId());
    }
}
