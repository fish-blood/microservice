package com.wt.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Date;
import java.util.concurrent.*;

public class ThreadPoolUtil {
    /**
     * 固定线程池创建
     * corePoolSize – 要保留在池中的线程数，即使它们处于空闲状态，
     * 除非 allowCoreThreadTimeOut 设置为
     * maxumPoolSize – 池中允许的最大线程数
     * keepAliveTime – 当线程数大于核心时，这是多余的空闲线程在终止之前等待新任务的最长时间。
     * unit – keepAliveTime 参数的时间单位
     * workQueue – 用于在执行任务之前保存任务的队列。此队列将仅保存由 execute 方法提交的可运行任务。 使用链式阻塞队列
     */
    public static final int THREAD_SIZE = 4;
    //固定线程池
    public static ExecutorService FIXED_THREAD_POOL = Executors.newFixedThreadPool(THREAD_SIZE);

    public static ExecutorService executor = new ThreadPoolExecutor(4, 4,
            0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new ThreadFactoryBuilder().setNameFormat("user-pool-%d").build());

    /**
     * 缓存线程池创建
     * corePoolSize 为0
     * maxumPoolSize – Integer.max_value 有空闲线程使用空闲线程，无则创建新线程
     * keepAliveTime – 默认60s
     * unit – keepAliveTime 参数的时间单位
     * workQueue – 使用同步队列
     */
    public static ExecutorService CACHED_THREAD_POOL = Executors.newCachedThreadPool();
    /**
     * 单线程线程池创建
     * corePoolSize 为1
     * maxumPoolSize – 1
     * keepAliveTime – 默认0s
     * unit – keepAliveTime 参数的时间单位
     * workQueue – 使用链式阻塞队列
     */
    public static ExecutorService SINGLE_THREAD_POOL = Executors.newSingleThreadExecutor();
    /**
     * 延时任务线程池创建
     * corePoolSize 为1
     * maxumPoolSize – Integer.Max_value
     * keepAliveTime – 默认0s
     * unit – keepAliveTime 参数的时间单位
     * workQueue – 使用延迟工作队列
     */
    public static void SingleThreadScheduledExecutor() {
        // 创建线程池
        ScheduledExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();
        // 添加定时执行任务(2s 后执行)
        System.out.println("添加任务,时间:" + new Date());
        threadPool.schedule(() -> {
            System.out.println("任务被执行,时间:" + new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
        }, 2, TimeUnit.SECONDS);
    }
    /**
     * 抢占式线程池
     *
     */
    public static void workStealingPool() {
        // 创建线程池
        ExecutorService threadPool = Executors.newWorkStealingPool();
        // 执行任务
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPool.execute(() -> {
                System.out.println(index + " 被执行,线程名:" + Thread.currentThread().getName());
            });
        }
        // 确保任务执行完成
        while (!threadPool.isTerminated()) {
        }
    }
    /**
     * 原始线程池
     *
     */
    public static void myThreadPoolExecutor() {
        // 创建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 100, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.AbortPolicy());


        // 执行任务
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPool.execute(() -> {
                System.out.println(index + " 被执行,线程名:" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }


}
