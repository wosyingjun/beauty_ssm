package com.yingjun.ssm.entity;

import java.util.Date;

/**
 * 订单
 * @author yingjun
 *
 */
public class Order {
	
	private long orderId;
	
	private User user;
	
	private long goodsId;
	
	private String title;
	
	private Date createTime;


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public long getGoodsId() {
		return goodsId;
	}


	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}


	@Override
	public String toString() {
		return "Order [user=" + user + ", orderId=" + orderId + ", goodsId=" + goodsId + ", title=" + title + ", createTime=" + createTime + "]";
	}



	
	
}
