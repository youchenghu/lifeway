package com.hyc.lifeway.api.task;

import com.hyc.cs.core.security.Authorization;
import com.hyc.lifeway.common.BaseApi;
import com.hyc.lifeway.module.task.model.Task;
import com.hyc.lifeway.module.task.service.TaskService;
import com.hyc.lifeway.module.user.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ：胡友成
 * @Date ：2020/4/13 12:20 下午
 * @Description：
 */
@RestController

@RequestMapping("/task")
@Api(tags = "任务Api")
public class TaskApi extends BaseApi {

    @Autowired
    TaskService taskService;

    @ApiOperation("获取用户创建的任务")
    @Authorization
    @GetMapping("/fromMe")
    public void fromMe() {
        User accessUser = getAccessUser();
        List<Task> userCreatedTasks = taskService.getUserCreatedTasks(accessUser.getId());
        setAttr("tasks", userCreatedTasks);
        System.out.println(1);
    }
}
