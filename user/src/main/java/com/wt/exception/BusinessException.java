package com.wt.exception;

import com.wt.dto.api.IResultCode;
import com.wt.dto.api.ResultCode;
import com.wt.util.StringUtil;

/**
 * 业务异常,用于记录服务器异常
 */
public class BusinessException extends BaseException {

    public BusinessException(String message) {
        super(ResultCode.ERROR.getCode(), message);
    }

    public BusinessException(String message, String... strings) {
        super(ResultCode.ERROR.getCode(), StringUtil.fillString(message, strings));
    }

    public BusinessException(IResultCode code) {
        super(code);
    }

    public BusinessException(int code, String message) {
        super(code, message);
    }

    public BusinessException(IResultCode code, Object... msg) {
        super(code, msg);
    }
}
