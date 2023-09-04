package com.wt.dto.api;

import com.wt.constant.MateConstant;
import com.wt.exception.UserException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * 统一响应消息报文
 *
 * @param <T> 　T对象
 * @author pangu
 */
@Data
@Getter
@NoArgsConstructor
@ApiModel(value = "统一响应消息报文")
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1316L;

	@ApiModelProperty(value = "状态码", required = true)
	private int code;

	@ApiModelProperty(value = "消息内容", required = true)
	private String msg;

	@ApiModelProperty(value = "时间戳", required = true)
	private long time;

	@ApiModelProperty(value = "业务数据")
	private T data;

	private String stack;

	private Result(IResultCode resultCode) {
		this(resultCode, null, resultCode.getMsg());
	}

	private Result(IResultCode resultCode, String msg) {
		this(resultCode, null, msg);
	}

	private Result(IResultCode resultCode, T data) {
		this(resultCode, data, resultCode.getMsg());
	}

	private Result(IResultCode resultCode, T data, String msg) {
		this(resultCode.getCode(), data, msg);
	}

	private Result(int code, T data, String msg) {
		this.code = code;
		this.data = data;
		this.msg = msg;
		this.time = System.currentTimeMillis();
	}


	public static <T> Result<T> success() {
		return new Result<>(ResultCode.SUCCESS);
	}

	public static <T> Result<T> success(IResultCode resultCode) {
		return new Result<>(resultCode);
	}

	public static <T> Result<T> success(String msg) {
		return new Result<>(ResultCode.SUCCESS, msg);
	}

	public static <T> Result<T> success(IResultCode resultCode, String msg) {
		return new Result<>(resultCode, msg);
	}

	public static <T> Result<T> success(T data) {
		return data(data, MateConstant.DEFAULT_SUCCESS_MESSAGE);
	}

	public static <T> Result<T> data(T data) {
		return data(data, MateConstant.DEFAULT_SUCCESS_MESSAGE);
	}

	public static <T> Result<T> data(T data, String msg) {
		return data(ResultCode.SUCCESS.code, data, msg);
	}

	public static <T> Result<T> data(int code, T data, String msg) {
		return new Result<>(code, data, data == null ? MateConstant.DEFAULT_NULL_MESSAGE : msg);
	}

	public static <T> Result<T> fail() {
		return new Result<>(ResultCode.FAILURE, ResultCode.FAILURE.getMsg());
	}

	public static <T> Result<T> fail(String msg) {
		return new Result<>(ResultCode.FAILURE, msg);
	}

	public static <T> Result<T> fail(int code, String msg) {
		return new Result<>(code, null, msg);
	}

	public static <T> Result<T> fail(IResultCode resultCode) {
		return new Result<>(resultCode);
	}

	public static <T> Result<T> fail(IResultCode resultCode, String msg) {
		return new Result<>(resultCode, msg);
	}

	public static <T> Result<T> condition(boolean flag) {
		return flag ? success(MateConstant.DEFAULT_SUCCESS_MESSAGE) : fail(MateConstant.DEFAULT_FAIL_MESSAGE);
	}

	/** 检查并抛出异常 慎用,如果想捕获异常请勿使用 **/
	public Result<T> check() {
		if(ResultCode.SUCCESS.code != this.code){
			throw new UserException(this.code,this.msg);
		}
		return this;
	}

	/** 检查并忽略异常(data设置为一个属性都为null的对象) 慎用,如果想捕获异常请勿使用 **/
	public Result<T> checkIgnore() {
		if(ResultCode.SUCCESS.code != this.code){
			this.setCode(ResultCode.SUCCESS.code);
			this.setData(getInstanceOfT());
		}
		return this;
	}

	public boolean isSuccess() {
		return this.code == ResultCode.SUCCESS.getCode();
	}

	public boolean isFail() {
		return this.code != ResultCode.SUCCESS.getCode();
	}

	protected T getInstanceOfT() {
		ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
		Class<T> type = (Class<T>) superClass.getActualTypeArguments()[0];
		try
		{
			return type.newInstance();
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	private Class<T> getClassOfT() {
		ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
		Class<T> type = (Class<T>) superClass.getActualTypeArguments()[0];
		return type;
	}
}
