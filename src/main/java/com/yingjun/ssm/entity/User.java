package com.yingjun.ssm.entity;

import java.util.Date;


/**
 * 用户
 * @author  yingjun
 *
 */
public class User {
	
	private long userId;
	
	private String userName;
	
	private long userPhone;
	
	private Date createTime;
	
	private int score;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPhone=" + userPhone + ", createTime=" + createTime + ", score=" + score
				+ "]";
	}

	

}
