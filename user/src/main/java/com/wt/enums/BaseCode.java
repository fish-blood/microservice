package com.wt.enums;

/**
 * @version V1.0
 * @description: 状态码接口
 * @author:
 * @contact: QQ791156095
 * @date: 2020/8/28 17:16
 * @Copyright 该项目由宏伟数科版权所有，未经过允许的情况下，私自分享视频和源码属于违法行为。
 */
public interface BaseCode {
    /**
     * 异常编码
     *
     * @return
     */
    int getCode();

    /**
     * 异常消息
     *
     * @return
     */
    String getMsg();
}
