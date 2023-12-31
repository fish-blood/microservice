package com.wt.dto.api;

/**
 * 返回码接口
 *
 * @author pangu
 */
public interface IResultCode {

	/**
	 * 返回码
	 *
	 * @return int
	 */
	int getCode();

	/**
	 * 返回消息
	 *
	 * @return String
	 */
	String getMsg();

//	/**
//	 * 返回默认消息
//	 *
//	 * @return String
//	 */
//	String getDefaultMsg();

}
