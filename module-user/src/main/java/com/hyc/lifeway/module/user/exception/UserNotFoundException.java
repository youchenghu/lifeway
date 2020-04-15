package com.hyc.lifeway.module.user.exception;

import com.hyc.cs.core.exception.HappyException;

/**
 * @Author ：胡友成
 * @Date ：2020/4/15 9:02 下午
 * @Description：
 */
public class UserNotFoundException extends HappyException {
    public UserNotFoundException() {
        super(10000);
    }
}
