package com.yingjun.ssm.service;

import java.util.List;

import com.yingjun.ssm.entity.User;

public interface UserService {

	List<User> getUserList(int offset, int limit);
	 
}
