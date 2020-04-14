package com.hyc.lifeway.api.user;

import com.hyc.cs.core.web.resolve.annotation.ResolveField;
import com.hyc.lifeway.common.BaseApi;
import com.hyc.lifeway.module.user.model.User;
import com.hyc.lifeway.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ：胡友成
 * @Date ：2020/4/8 10:16 下午
 * @Description：
 */
@RestController
public class UserApi extends BaseApi {

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello Lifeway!";
    }

    @GetMapping("/hello2")
    public void hello2() {
        User byId = userService.getById(1);
        setAttr("user", byId);
    }

    @GetMapping("/hello3")
    public void hello3(@ResolveField("user_id") Integer userId) {
        User byId = userService.getById(userId);
        setAttr("user", byId);
    }
}
