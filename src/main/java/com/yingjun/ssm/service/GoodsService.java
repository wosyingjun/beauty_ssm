package com.yingjun.ssm.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.yingjun.ssm.entity.Goods;

public interface GoodsService {

	/**
	 * 根据偏移量查询可用商品列表
	 *
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Goods> getGoodsList(int offset, int limit);

	/**
	 * 商品购买
	 * 
	 * @param userId
	 * @param goodsId
	 * @param useProcedure
	 *            是否用存储过程提高并发能力
	 */
	
	void buyGoods(long userPhone, long goodsId, boolean useProcedure);

}
