package com.hyc.lifeway.module.user.exception;

import com.hyc.cs.core.exception.HappyException;

/**
 * @Author ：胡友成
 * @Date ：2020/4/17 9:42 下午
 * @Description：
 */
public class UserTaskNotFoundException extends HappyException {
    public UserTaskNotFoundException() {
        super(10001);
    }
}
