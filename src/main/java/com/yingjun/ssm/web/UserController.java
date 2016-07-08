package com.yingjun.ssm.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yingjun.ssm.entity.User;
import com.yingjun.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, Integer offset, Integer limit) {
		LOG.info("invoke----------/user/list");
		offset = offset == null ? 0 : offset;//默认便宜0
		limit = limit == null ? 50 : limit;//默认展示50条
		List<User> list = userService.getUserList(offset, limit);
		model.addAttribute("userlist", list);
		return "userlist";
	}

}
