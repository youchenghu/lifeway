package com.hyc.lifeway.api.user;

import com.hyc.cs.core.exception.PermissionDeniedException;
import com.hyc.cs.core.security.Authorization;
import com.hyc.cs.core.web.resolve.annotation.ResolveField;
import com.hyc.lifeway.api.user.vo.UserTaskVO;
import com.hyc.lifeway.common.BaseApi;
import com.hyc.lifeway.module.task.service.TaskService;
import com.hyc.lifeway.module.user.exception.UserTaskNotFoundException;
import com.hyc.lifeway.module.user.model.User;
import com.hyc.lifeway.module.user.model.UserTask;
import com.hyc.lifeway.module.user.service.UserTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    TaskService taskService;

    @ApiOperation("获取用户任务列表")
    @Authorization
    @GetMapping("/list")
    public void list() {
        User accessUser = getAccessUser();
        List<UserTask> userTasks = userTaskService.getUserTasks(accessUser.getId());

        List<UserTaskVO> userTaskVOS = userTasks.stream().map(o -> {
            UserTaskVO userTaskVO = new UserTaskVO(o);
            userTaskVO.setTask(taskService.getById(o.getTaskId()));
            userTaskVO.setTaskId(null);
            return userTaskVO;
        }).collect(Collectors.toList());
        setAttr("user_tasks", userTaskVOS);
    }

    @ApiOperation("获取用户任务详情")
    @Authorization
    @GetMapping("/detail")
    public void detail(@ResolveField("id") Integer id) {
        User accessUser = getAccessUser();
        UserTask userTask = userTaskService.getById(id);
        if(userTask == null){
            throw new UserTaskNotFoundException();
        }

        if(!userTask.getUserId().equals(accessUser.getId())){
            throw new PermissionDeniedException();
        }

        UserTaskVO userTaskVO = new UserTaskVO(userTask);
        userTaskVO.setTask(taskService.getById(userTask));
        userTaskVO.setTaskId(null);
        setAttr("user_task", userTaskVO);
    }

    @ApiOperation("完成任务")
    @Authorization
    @GetMapping("/finish")
    public void finish(@ResolveField("id") Integer id) {
        User accessUser = getAccessUser();
        UserTask finishedTask = userTaskService.finishTask(accessUser.getId(), id);
        setAttr("user_task", finishedTask);
    }
}
