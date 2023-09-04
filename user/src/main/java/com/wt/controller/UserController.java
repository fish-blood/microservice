package com.wt.controller;

import com.wt.dto.api.Result;
import com.wt.entity.User;
import com.wt.service.UserService;
import com.wt.util.ThreadPoolUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@Validated
@RestController
@RequestMapping("/user")
@Api(tags={"用户接口"})
public class UserController {
    @Resource
    private UserService userService;
    //测试调优参数
    @GetMapping
    @ApiOperation("用户列表")
    public Result<List<User>> page(){
        return Result.success(userService.list());
    }
}
