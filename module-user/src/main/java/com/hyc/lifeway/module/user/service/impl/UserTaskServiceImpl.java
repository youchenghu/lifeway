package com.hyc.lifeway.module.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hyc.lifeway.module.user.model.UserTask;
import com.hyc.lifeway.module.user.dao.UserTaskDao;
import com.hyc.lifeway.module.user.service.UserTaskService;
import com.hyc.cs.core.common.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: MyBatis Plus Generator
 * @Date: 2020-04-16
 * @Description:
 */
@Service
public class UserTaskServiceImpl extends BaseServiceImpl<UserTaskDao, UserTask> implements UserTaskService {

    @Override
    public List<UserTask> getUserTasks(Integer userId) {
        QueryWrapper<UserTask> qw = new QueryWrapper<>();
        qw.eq("user_id", userId);
        return baseMapper.selectList(qw);
    }
}
