package com.wt.dto.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回码实现
 *
 * @author pangu
 */

@Getter
@AllArgsConstructor
public enum ResultCode implements IResultCode {

    /**
     * 操作成功
     */
    SUCCESS(0, "操作成功"),
    /**
     * 业务异常
     */
    FAILURE(400, "业务异常"),

    /**
     * 其他 通用异常 格式 99开头 共5位
     */
    Uncategorized_SQLException(99101, "请勿输入特殊字符"),//数据库数据类型不符异常

    EXCEL_EXCEPTION_INSERT(99102, "请下载正确的导入模板、导入模板不符合要求"),//导入模板不合格

    /**
     * security 相关  格式 88开头 共5位
     */
    NOT_AUTHENTICATION(88101, "权限不足"),
    LOGIN_SERVICE_ERROR(88102, "登录服务异常"),
    LOGIN_ERROR_LOCK(88103, "您的账号已被停用，请联系管理员"),
    USER_NOT_FOUND(1010102, "该账号未注册，请联系平台客服"),
    USER_LOGIN_EXPIRED(1010104, "用户登录过期,请重新登录"),
    TOKEN_ERROR(1010105, "未登录或登陆过期,请重新登录"),
    TOKEN_AUTH_ERROR(1010111, "token认证错误"),
    VERIFY_CODE_ERROR(1010112, "验证码错误"),
    USERNAME_PASSWORD_ERROR(1010113, "用户名或密码错误"),

    /**
     * 适配app端,点击返回异常
     */
    APP_CONFIRM_RETURN(11111, "{0}"),


    /**
     * 服务未找到
     */
    NOT_FOUND(404, "服务未找到"),
    /**
     * 服务异常
     */
    ERROR(500, "服务异常"),
    /**
     * Too Many Requests
     */
    TOO_MANY_REQUESTS(429, "Too Many Requests"),
    /**
     * 参数错误
     */
    GLOBAL_PARAM_ERROR(4000, "参数错误"),


    /**
     * 获取当前用户失败
     */
    CURRENT_USER_FAIL(10001, "获取当前用户失败"),
    /**
     * 用户是超级管理员，不可以修改状态
     */
    UPDATE_USER_STATUS(10002, "用户是超级管理员，不可以修改状态"),
    /**
     * 用户是超级管理员，不可以修改密码
     */
    UPDATE_USER_PASSWORD(10003, "用户是超级管理员，不可以修改密码"),
    /**
     * 用户未登录，请登陆后进行访问
     */
    USER_NEED_LOGIN(11001, "用户未登录，请登陆后进行访问"),
    /**
     * 该用户已在其它地方登录
     */
    USER_MAX_LOGIN(11002, "该用户已在其它地方登录"),
    /**
     * 长时间未操作，自动退出
     */
    USER_LOGIN_TIMEOUT(11003, "长时间未操作，自动退出"),
    /**
     * 用户被禁11005用
     */
    USER_DISABLED(11004, "用户被禁11005用"),
    /**
     * 用户被锁定
     */
    USER_LOCKED(11005, "用户被锁定"),
    /**
     * 用户名或密码错误
     */
    USER_PASSWORD_ERROR(11006, "用户名或密码错误"),
    /**
     * 用户密码过期
     */
    USER_PASSWORD_EXPIRED(11007, "用户密码过期"),
    /**
     * 用户账号过期
     */
    USER_ACCOUNT_EXPIRED(11008, "用户账号过期"),
    /**
     * 没有该用户
     */
    USER_NOT_EXIST(11009, "没有该用户"),
    /**
     * 用户登录失败
     */
    USER_LOGIN_FAIL(11010, "用户登录失败"),
    /**
     * 用户已存在
     */
    USER_IS_EXIST(11012, "账号已存在"),
    /**
     * 用户旧密码不正确
     */
    USER_OLDPASSWORD_ERROR(11013, "用户旧密码不正确"),
    /**
     * 无权访问
     */
    NO_AUTHENTICATION(1003006, "无权访问"),
    /**
     * 角色ID无效
     */
    ROLE_IS_NOT_EXIST(13001, "角色ID无效"),
    /**
     * 角色代码已存在
     */
    ROLE_IS_EXIST(13002, "角色代码已存在"),
    /**
     * 配置信息为空
     */
    CONFIG_ID_IS_NOT_EXIST(14001, "配置信息为空"),
    /**
     * 配置ID无效
     */
    CONFIG_IS_NOT_EXIST(14002, "配置ID无效"),
    /**
     * 配置ID已存在
     */
    CONFIG_IS_EXIST(14002, "配置ID已存在"),
    /**
     * 系统配置不允许修改
     */
    CONFIG_IS_SYSTEM(14003, "系统配置不允许修改"),
    /**
     * 系统配置不允许删除
     */
    CONFIG_IS_NOT_DELETE(14003, "系统配置不允许删除"),
    /**
     * 文件不存在
     */
    FILE_DOES_NOT_EXIST(16001, "文件不存在"),
    /**
     * 文件上传异常
     */
    FILE_UPLOAD_EXCEPTION(16002, "文件上传异常"),
    /**
     * 文件下载异常
     */
    FILE_DOWNLOAD_ABNORMAL(16003, "文件下载异常"),
    /**
     * 无效的资源ID
     */
    RESOURCE_NOT_FIND(12001, "无效的资源ID"),
    /**
     * 资源ID已存在
     */
    RESOURCE_IS_EXIST(12001, "资源ID已存在"),
    /**
     * 无效资源父节点ID
     */
    RESOURCE_PARENT_NOT_FIND(12002, "无效资源父节点ID"),
    /**
     * 无效资源父节点ID
     */
    RESOURCE_PARENT_INVALID(12003, "无效资源父节点ID"),
    /**
     * 该资源下有子资源，不能删除
     */
    RESOURCE_HAVE_SUB(12004, "该资源下有子资源，不能删除"),
    /**
     * 机构已存在
     */
    ORG_IS_EXIST(17001, "机构已存在"),
    /**
     * 机构不存在
     */
    ORG_NOT_EXIST(17002, "机构不存在"),
    /**
     * 机构下存在用户
     */
    ORG_HAVE_USER(17003, "机构下存在用户"),
    /**
     * 无效机构父节点ID
     */
    ORG_PID_ERROR(17004, "无效机构父节点ID"),
    /**
     * 父级节点禁止删除
     */
    ORG_TOP_FORBID(17005, "父级节点禁止删除"),
    /**
     * 机构下存在子机构
     */
    ORG_HAVE_BRANCH(17006, "机构下存在子机构"),
    /**
     * 停用原因不能为空
     */
    ORG_STOP_REASON(17007, "停用原因不能为空"),

    //字典管理
    /**
     * 父级ID无效
     */
    DICT_PID_ERROR(18001, "父级ID无效"),
    /**
     * ID无效
     */
    DICT_ID_ERROR(18002, "ID无效"),
    /**
     * 字典code已存在
     */
    DICT_CODE_EXIST(18003, "字典code已存在"),
    /**
     * 字典name已存在
     */
    DICT_NAME_EXIST(18004, "字典name已存在"),
    /**
     * 字典下存在数据
     */
    DICT_HAVE_DATA(18005, "字典下存在数据"),
    /**
     * 字典不存在
     */
    DICT_NOT_EXIST(18006, "字典不存在"),
    /**
     * 存在子节点
     */
    DICT_HAVE_SON(18007, "存在子节点"),
    /**
     * 数据组信息不存在
     */
    GROUP_ID_ERROR(19001, "数据组信息不存在"),
    /**
     * 数据组初始化无机构信息
     */
    GROUP_INIT_DATA_ERROR(19002, "数据组初始化无机构信息"),


    /**
     * 交易相关 90XXX
     */


    TRANSACTION_AMOUNT_EMPTY(90001, "交易金额为空"),

    TRANSACTION_AMOUNT_INCONSISTENT(90002, "交易金额不一致"),

    /**
     * REDIS 分布式锁获取锁异常
     */
    REDIS_LOCK_FAILED(98000, "获取分布式锁失败，KEY：{0}"),

    /**
     * 服务异常
     */
    USER_CENTER_SERVICE_ERROR(99001, "USER-CENTER-SERVICE异常"),
    GOODS_CENTER_SERVICE_ERROR(99002, "GOODS-CENTER-SERVICE异常"),
    ORDER_CENTER_SERVICE_ERROR(99003, "ORDER-CENTER-SERVICE异常"),
    CRM_FEIGN_SERVICE_ERROR(99006, "CRM-FEIGN-SERVICE异常"),
    OMS_FEIGN_SERVICE_ERROR(99007, "OMS-FEIGN-SERVICE异常"),
    WMS_FEIGN_SERVICE_ERROR(99008, "WMS-FEIGN-SERVICE异常"),
    TMS_FEIGN_SERVICE_ERROR(99009, "WMS-FEIGN-SERVICE异常"),

    /**
     * oms审核，退仓是否继续审核的唯一标识码
     */
    OMS_AUDIT_AND_PUSH_ERROR(20001, "oms审核，退仓是否继续审核的唯一标识码"),
    ;

    /**
     * 状态码
     */
    final int code;
    /**
     * 消息内容
     */
    final String msg;

//	@Override
//	public String getDefaultMsg() {
//		return "服务器异常";
//	}
}
