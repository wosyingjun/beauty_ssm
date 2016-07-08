package com.yingjun.ssm.dto;

import java.io.Serializable;

public class OrderResultDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private long orderId;
	
	private long goodsId;
	
	private String title;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "OrderResultDto [orderId=" + orderId + ", goodsId=" + goodsId + ", title=" + title + "]";
	}


}
