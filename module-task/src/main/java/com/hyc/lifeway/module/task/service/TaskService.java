package com.hyc.lifeway.module.task.service;

import com.hyc.lifeway.module.task.model.Task;
import com.hyc.cs.core.common.BaseService;
import com.hyc.lifeway.module.user.model.User;

import java.util.List;

/**
 * @Author: MyBatis Plus Generator
 * @Date: 2020-04-11
 * @Description:
 */
public interface TaskService extends BaseService<Task> {

    /**
     * 获取用户创建的任务
     * @param userId
     * @return
     */
    List<Task> getUserCreatedTasks(Integer userId);

}
