package com.yingjun.ssm.enums;

public enum ResultEnum {

	SUCCESS(1, "成功"),
	INVALID_USER(-1, "无效用户"), 
	PARAM_USER(-2, "参数错误"), 
	INNER_ERROR(-3, "系统异常");

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
