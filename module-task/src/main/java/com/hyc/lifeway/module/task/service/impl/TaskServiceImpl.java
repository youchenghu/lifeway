package com.hyc.lifeway.module.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hyc.lifeway.module.task.model.Task;
import com.hyc.lifeway.module.task.dao.TaskDao;
import com.hyc.lifeway.module.task.service.TaskService;
import com.hyc.cs.core.common.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: MyBatis Plus Generator
 * @Date: 2020-04-11
 * @Description:
 */
@Service
public class TaskServiceImpl extends BaseServiceImpl<TaskDao, Task> implements TaskService {

    @Override
    public List<Task> getUserCreatedTasks(Integer userId) {
        QueryWrapper<Task> qw = new QueryWrapper<>();
        qw.eq("creator", userId);
        qw.orderByDesc("create_time");
        return baseMapper.selectList(qw);
    }
}
