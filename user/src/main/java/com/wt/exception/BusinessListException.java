package com.wt.exception;

import com.wt.dto.api.IResultCode;

/**
 * 业务异常,用于记录服务器异常
 */
public class BusinessListException extends RuntimeException {

    private static final long serialVersionUID = -6403918450137506144L;

    protected int code;

    protected Object info;

    public BusinessListException(IResultCode code, Object info) {
        super(code.getMsg());
        this.code = code.getCode();
        this.info = info;
    }

    public BusinessListException(int code, String msg, Object info) {
        super(msg);
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public Object getInfo() {
        return info;
    }
}
