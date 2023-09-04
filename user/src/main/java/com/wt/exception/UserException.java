package com.wt.exception;


import com.wt.dto.api.IResultCode;
import com.wt.util.StringUtil;

/**
 * 用户操作异常,用于指示用户变更自己的行为,不提示系统异常
 * 如: ...参数错误;...登录超时;...非授权操作;
 */
public class UserException extends BaseException{


    private String data;

    private String stack;

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, String... strings) {
        super(StringUtil.fillString(message, strings));
    }

    public UserException(IResultCode code){
        super(code);
    }

    public UserException(int code, String message) {
        super(code, message);
    }
    public UserException(int code, String message, String stack) {
        super(code, message);
        this.stack = stack;
    }
    public UserException(IResultCode code, Object... msg){
        super(code,msg);
    }

    public Object getData(){
        return data;
    }

    public UserException setData(String data){
        this.data = data;
        return this;
    }
    public String getStack(){
        return stack;
    }

    public UserException setStack(String stack){
        this.data = data;
        return this;
    }
    public UserException setResultCode(IResultCode code){
        this.code = code.getCode();
        return this;
    }
}
