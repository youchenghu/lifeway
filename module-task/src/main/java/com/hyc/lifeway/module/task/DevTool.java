package com.hyc.lifeway.module.task;

import com.hyc.cs.devtool.CodeGenerator;
import com.hyc.cs.devtool.DataSource;

import java.util.Arrays;

/**
 * @Author ：胡友成
 * @Date ：2020/4/8 11:11 上午
 * @Description：
 */
public class DevTool {
    public static void main(String[] args) {
        new CodeGenerator()
                .setDataSource(DataSource.PRIMARY)
                .setReferenceClass(DevTool.class)
                .setModuleName("")
                .setTables(Arrays.asList(
                        "task"
                ))
                .run();
    }
}
