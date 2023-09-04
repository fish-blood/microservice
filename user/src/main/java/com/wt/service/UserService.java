package com.wt.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.entity.User;
import com.wt.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * (user)数据DAO
 *
 * @author kancy
 * @since 2023-09-02 15:25:28
 * @description 由 Mybatisplus Code Generator 创建
 */
@Slf4j
@Repository
public class UserService extends ServiceImpl<UserMapper, User> {

}