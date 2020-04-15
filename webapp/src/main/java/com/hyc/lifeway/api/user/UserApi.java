package com.hyc.lifeway.api.user;

import com.hyc.cs.core.security.Authorization;
import com.hyc.cs.core.web.resolve.annotation.ResolveField;
import com.hyc.lifeway.common.BaseApi;
import com.hyc.lifeway.module.user.model.User;
import com.hyc.lifeway.module.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ：胡友成
 * @Date ：2020/4/8 10:16 下午
 * @Description：
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户Api")
public class UserApi extends BaseApi {

    @Autowired
    UserService userService;

    @ApiOperation("用户登录")
    @GetMapping("/login")
    public void login(String phone) {
        User user = userService.getByPhone(phone);
        String token = userService.generateAccessToken(user);
        setAttr("token", token);
    }

    @ApiOperation("获取用户信息")
    @Authorization
    @GetMapping("/getInfo")
    public void getInfo() {
        User accessUser = getAccessUser();
        setAttr("user_info", accessUser);
    }
}
