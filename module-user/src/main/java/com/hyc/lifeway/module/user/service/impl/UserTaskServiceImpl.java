package com.hyc.lifeway.module.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hyc.cs.core.exception.PermissionDeniedException;
import com.hyc.lifeway.module.user.enums.UserTaskStatus;
import com.hyc.lifeway.module.user.exception.UserTaskNotFoundException;
import com.hyc.lifeway.module.user.model.UserTask;
import com.hyc.lifeway.module.user.dao.UserTaskDao;
import com.hyc.lifeway.module.user.service.UserTaskService;
import com.hyc.cs.core.common.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public UserTask finishTask(Integer userId, Integer userTaskId) {
        UserTask userTask = baseMapper.selectById(userTaskId);
        if (userTask == null) {
            throw new UserTaskNotFoundException();
        }

        if (!userTask.getUserId().equals(userId)) {
            throw new PermissionDeniedException();
        }

        userTask.setFinishTime(LocalDateTime.now());
        userTask.setStatus(UserTaskStatus.FINISHED.getStatus());
        baseMapper.updateById(userTask);
        return userTask;
    }
}
