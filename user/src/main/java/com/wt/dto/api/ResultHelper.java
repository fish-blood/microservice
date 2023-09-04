package com.wt.dto.api;

public class ResultHelper {

    public Object getData(Result r) {
        // 1. 检查feign调用是否成功
        checkRemoteIsSuccess(r);

        // 2. 如果成功,返回正向逻辑
        return r.getData();
    }

    private void checkRemoteIsSuccess(Result r) {
        // 1. 判断错误码
        if (isFail(r)) {
            // TODO
        }
        // 2. 判断data 是否为空
    }


    public boolean isFail(Result r) {
        return r.getCode() != ResultCode.SUCCESS.getCode();
    }

}
