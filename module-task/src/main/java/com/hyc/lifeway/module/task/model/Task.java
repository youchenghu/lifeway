package com.hyc.lifeway.module.task.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.hyc.cs.core.common.BaseModel;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author: MyBatis Plus Generator
 * @Date: 2020-04-11
 * @Description: 
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Task对象", description="")
public class Task extends BaseModel<Task> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "任务名称")
    private String taskName;

    @ApiModelProperty(value = "任务描述")
    private String content;

    @ApiModelProperty(value = "任务创建者id")
    private Integer creator;

    @ApiModelProperty(value = "任务创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "任务图标")
    private String icon;

    @ApiModelProperty(value = "任务图片")
    private String picture;


}