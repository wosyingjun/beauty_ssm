package com.yingjun.ssm.dao;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yingjun.ssm.entity.Goods;
import com.yingjun.ssm.entity.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class OrderDaoTest {
	
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private GoodsDao goodsDao;

	@Test
	public void testInsertOrder() {
		Goods goods=goodsDao.queryAll(0, 1).get(0);
		System.out.println(goods);
		int result=orderDao.insertOrder(1000,goods.getGoodsId(),goods.getTitle());
		System.out.println("testInsertOrder result:"+result);
		System.out.println("--------------------------");
	}

	@Test
	public void testQueryByUserPhone() {
		List<Order> list=orderDao.queryByUserPhone(18768128888L);
		for (Order order : list) {
			System.out.println(order);
		}
		System.out.println("--------------------------");
	}

	@Test
	public void testQueryAll() {
		List<Order> list=new ArrayList<Order>();
		for (Order order : list) {
			System.out.println(order);
		}
		System.out.println("--------------------------");
	}

}
