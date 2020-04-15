package com.hyc.lifeway.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author ：胡友成
 * @Date ：2020/4/15 9:09 下午
 * @Description：
 */

@RestController
@Api(tags = "默认控制器")
public class DefaultController {

    @Autowired
    HttpServletResponse response;

    @ApiOperation(value = "设置默认页为Swagger-UI")
    @GetMapping(path = "/")
    public void Home() {
        response.setStatus(302);
        response.setHeader("Location", "swagger-ui.html");
    }
}
