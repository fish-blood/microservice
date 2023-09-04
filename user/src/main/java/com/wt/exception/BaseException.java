package com.wt.exception;


import com.wt.dto.api.IResultCode;
import com.wt.dto.api.ResultCode;

import java.text.MessageFormat;

/**
 * 通用异常
 *
 * @author pangu
 */
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 5782968730281544562L;

    protected int code;

    public BaseException(String message) {
        super(message);
        this.code = ResultCode.ERROR.getCode();
    }

    public BaseException(IResultCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
    }

    public BaseException(IResultCode resultCode, Object... msg) {
        super(MessageFormat.format(resultCode.getMsg(), msg));
        this.code = resultCode.getCode();

    }

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
