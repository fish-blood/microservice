package com.wt.enums;

/**
 * @version V1.0
 * @description: 平台状态
 * @author:
 * @contact:
 * @date: 2020/8/28 17:16
 * @Copyright 该项目由宏伟数科版权所有，未经过允许的情况下，私自分享视频和源码属于违法行为。
 */
public enum CodeEnum implements BaseCode {

    //系统相关
    SUCCESS(0, "成功"),
    FAIL(-1, "请求失败"),
    SYSTEM_BUSY(-2, "系统繁忙~请稍后再试~"),
    SYSTEM_TIMEOUT(-3, "系统维护中~请稍后再试~"),
    PARAM_EX(-4, "参数类型解析异常"),
    SQL_EX(-5, "运行SQL出现异常"),
    NULL_POINT_EX(-6, "空指针异常"),
    ILLEGALA_ARGUMENT_EX(-7, "无效参数异常"),
    MEDIA_TYPE_EX(-8, "请求类型异常"),
    LOAD_RESOURCES_ERROR(-9, "加载资源出错"),
    BASE_VALID_PARAM(-10, "统一验证参数异常"),
    OPERATION_EX(-11, "操作异常"),
    SERVICE_MAPPER_ERROR(-12, "Mapper类转换异常"),
    CAPTCHA_ERROR(-13, "验证码校验失败"),
    JSON_PARSE_ERROR(-14, "JSON解析异常"),
    REPEAT_ERROR(-15, "重复处理异常"),

    
    BAD_REQUEST(400, "错误的请求"),
    /**
     * {@code 401 Unauthorized}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7235#section-3.1">HTTP/1.1: Authentication, section 3.1</a>
     */
    UNAUTHORIZED(401, "未经授权"),
    /**
     * {@code 404 Not Found}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.4">HTTP/1.1: Semantics and Content, section 6.5.4</a>
     */
    NOT_FOUND(404, "没有找到资源"),
    METHOD_NOT_ALLOWED(405, "不支持当前请求类型"),

    TOO_MANY_REQUESTS(429, "请求超过次数限制"),
    INTERNAL_SERVER_ERROR(500, "内部服务错误"),
    BAD_GATEWAY(502, "网关错误"),
    GATEWAY_TIMEOUT(504, "网关超时"),
    //系统相关 end

    REQUIRED_FILE_PARAM_EX(1001, "请求中必须至少包含一个有效文件"),

    DATA_SAVE_ERROR(2000, "新增数据失败"),
    DATA_UPDATE_ERROR(2001, "修改数据失败"),
    TOO_MUCH_DATA_ERROR(2002, "批量新增数据过多"),
    //jwt token 相关 start

    JWT_BASIC_INVALID(40000, "无效的基本身份验证令牌"),
    JWT_TOKEN_EXPIRED(40001, "会话超时，请重新登录"),
    JWT_SIGNATURE(40002, "不合法的token，请认真比对 token 的签名"),
    JWT_ILLEGAL_ARGUMENT(40003, "缺少token参数"),
    JWT_GEN_TOKEN_FAIL(40004, "生成token失败"),
    JWT_PARSER_TOKEN_FAIL(40005, "解析用户身份错误，请重新登录！"),
    JWT_USER_INVALID(40006, "用户名或密码错误"),
    JWT_USER_ENABLED(40007, "用户已经被禁用！"),
    JWT_OFFLINE(40008, "您已在另一个设备登录！"),
    //jwt token 相关 end

    ;

    private final int code;
    private String msg;

    CodeEnum(final int code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }


    public CodeEnum build(final String msg, final Object... param) {
        this.msg = String.format(msg, param);
        return this;
    }

    public CodeEnum param(final Object... param) {
        this.msg = String.format(this.msg, param);
        return this;
    }

}
