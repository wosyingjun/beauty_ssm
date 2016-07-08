package com.yingjun.ssm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

import com.yingjun.ssm.entity.Goods;

public interface GoodsDao {
	 /**
     * 根据偏移量查询可用商品列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Goods> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 商品减库存
     *
     * @param goodsId
     * @return　如果更新行数大于1,表示更新的行数
     */
    int reduceNumber(long goodsId);

    /**
     * 使用存储过程执行抢购
     * 
     * 能提升并发性的原因：
     * 1、减少多个sql语句执行来回的网络延时。
     * 2、通过mysql自身的事物提升效率。
     * 
     * @param paramMap
     */
    void bugWithProcedure(Map<String, Object> paramMap);
    
    
}
