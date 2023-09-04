package com.wt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.entity.User;

public interface UserService extends IService<User> {
    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */

    User findUserByUserName(String userName);
}
