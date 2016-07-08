package com.yingjun.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yingjun.ssm.entity.User;

public interface UserDao {

	/**
     * 根据手机号查询用户对象
     *
     * @param userPhone
     * @return
     */
    User queryByPhone(long userPhone);
    
    
    /**
     * 根据偏移量查询用户列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<User> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    
    /**
     * 增加积分
     */
    void addScore(@Param("add")int add);
	
}
