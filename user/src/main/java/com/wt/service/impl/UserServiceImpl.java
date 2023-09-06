package com.wt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.entity.User;
import com.wt.mapper.UserMapper;
import com.wt.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.locks.ReentrantLock;

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
    public  User findUserByUserName(String userName) {
            //创建条件构造器对象
            LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getUsername,userName);
            //执行查询
            notify();
            return baseMapper.selectOne(queryWrapper);
    }
    private volatile static UserServiceImpl uniqueInstance;
    private UserServiceImpl() {
    }
    public static UserServiceImpl getUniqueInstance() {
//先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
//类对象加锁
            synchronized (UserServiceImpl.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new UserServiceImpl();
                }
            }
        }
        return uniqueInstance;
    }
    public void test(){
        /**
         *和synchronized都是可重入锁
         * synchronized 是jvm层面的锁，底层为monitor,转为为。class文件时可看出：
         * 锁代码块时：采用monitorenter以及monitorexit进行代码片段的枷锁
         * 锁方法时：采用acc_synchronized标识，让jvm知道方法为同步调用方法
         * ReentrantLock是jdk也就是api层面的锁
         * 通过lock()方法加锁，unlock()方法释放锁（需要结合try/final使用）
         */
        ReentrantLock lock=new ReentrantLock(false);
        try{
            boolean b = lock.tryLock();
            if(!b){
                lock.lockInterruptibly();
            }
        }catch (Exception e){
            log.info(e.getMessage());
        }finally {
            lock.unlock();
        }
    }
}