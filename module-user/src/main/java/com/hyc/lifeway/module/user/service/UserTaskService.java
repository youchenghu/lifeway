package com.hyc.lifeway.module.user.service;

import com.hyc.lifeway.module.user.model.UserTask;
import com.hyc.cs.core.common.BaseService;

import java.util.List;

/**
 * @Author: MyBatis Plus Generator
 * @Date: 2020-04-16
 * @Description:
 */
public interface UserTaskService extends BaseService<UserTask> {
    /**
     * 获取用户的任务
     * @param userId
     * @return
     */
    List<UserTask> getUserTasks(Integer userId);

    /**
     * 完成任务
     * @param userId
     * @param userTaskId
     * @return
     */
    UserTask finishTask(Integer userId, Integer userTaskId);
}
