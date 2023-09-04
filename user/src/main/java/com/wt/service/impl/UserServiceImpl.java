package com.wt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.entity.User;
import com.wt.mapper.UserMapper;
import com.wt.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * (user)数据DAO
 *
 * @author wt
 * @since 2023-09-02 15:25:28
 * @description 由 Mybatisplus Code Generator 创建
 */
@Slf4j
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User findUserByUserName(String userName) {
        //创建条件构造器对象
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,userName);
        //执行查询
        return baseMapper.selectOne(queryWrapper);
    }
}