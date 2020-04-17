package com.hyc.lifeway.api.user.vo;

import com.hyc.cs.core.util.BeanUtil;
import com.hyc.lifeway.module.task.model.Task;
import com.hyc.lifeway.module.user.model.UserTask;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author ：胡友成
 * @Date ：2020/4/17 10:08 下午
 * @Description：
 */

@Data
public class UserTaskVO extends UserTask {

    public UserTaskVO(UserTask userTask){
        if(userTask != null){
            BeanUtil.copyProperties(userTask, this);
        }
    }

    @ApiModelProperty(value = "任务对象")
    private Task task;
}
