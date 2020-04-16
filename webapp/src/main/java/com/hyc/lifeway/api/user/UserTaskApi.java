package com.hyc.lifeway.api.user;

import com.hyc.cs.core.security.Authorization;
import com.hyc.lifeway.common.BaseApi;
import com.hyc.lifeway.module.user.model.User;
import com.hyc.lifeway.module.user.model.UserTask;
import com.hyc.lifeway.module.user.service.UserService;
import com.hyc.lifeway.module.user.service.UserTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ：胡友成
 * @Date ：2020/4/8 10:16 下午
 * @Description：
 */
@RestController
@RequestMapping("/user/task")
@Api(tags = "用户任务Api")
public class UserTaskApi extends BaseApi {

    @Autowired
    UserTaskService userTaskService;

    @ApiOperation("获取用户任务列表")
    @Authorization
    @GetMapping("/list")
    public void list() {
        User accessUser = getAccessUser();
        List<UserTask> userTasks = userTaskService.getUserTasks(accessUser.getId());
        setAttr("user_tasks", userTasks);
    }
}
