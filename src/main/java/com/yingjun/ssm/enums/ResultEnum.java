package com.yingjun.ssm.enums;

/**
 * 业务异常基类，所有业务异常都必须继承于此异常 定义异常时，需要先确定异常所属模块。 例如：无效用户可以定义为 [10010001]
 * 前四位数为系统模块编号，后4位为错误代码 ,唯一。
 * 
 * @author yingjun
 *
 */
public enum ResultEnum {

	// 数据库想操作异常
	DB_INSERT_RESULT_ERROR(99990001, "db insert error"),
	DB_UPDATE_RESULT_ERROR(99990002, "db update error"),
	DB_SELECTONE_IS_NULL(99990003,"db select return null"),

	// 系统异常
	INNER_ERROR(99980001, "系统错误"), 
	TOKEN_IS_ILLICIT(99980002, "Token验证非法"), 
	SESSION_IS_OUT_TIME(99980003, "会话超时"),

	// 用户相关异常
	INVALID_USER(1001001, "无效用户");

	private int state;

	private String msg;

	ResultEnum(int state, String msg) {
		this.state = state;
		this.msg = msg;
	}

	public int getState() {
		return state;
	}

	public String getMsg() {
		return msg;
	}

	public static ResultEnum stateOf(int index) {
		for (ResultEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
