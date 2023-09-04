package com.wt.service.login;


import com.wt.entity.User;
import com.wt.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;


public class CustomerUserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserService userService;



    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据对象查找用户信息
        User user = userService.findUserByUserName(username);
        //判断对象是否为空
        if(user==null){
            throw new UsernameNotFoundException("用户的账号密码错误");
        }
        //查询当前登录用户拥有权限列表
        //将权限编码转换成数据
        return user;
    }

}
