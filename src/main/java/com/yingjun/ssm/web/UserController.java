package com.yingjun.ssm.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yingjun.ssm.dto.BaseResult;
import com.yingjun.ssm.entity.User;
import com.yingjun.ssm.enums.ResultEnum;
import com.yingjun.ssm.exception.BizException;
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
		offset = offset == null ? 0 : offset;// 默认便宜0
		limit = limit == null ? 50 : limit;// 默认展示50条
		List<User> list = userService.getUserList(offset, limit);
		model.addAttribute("userlist", list);
		return "user/userlist";
	}

	/**
	 * 用json数据接收和返回
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = {
			"application/json;charset=UTF-8" })
	@ResponseBody
	public BaseResult<Object> login(HttpSession session,Long userPhone) {
		LOG.info("invoke----------/" + userPhone + "/login userPhone:" + userPhone);
		if (userPhone == null) {
			return new BaseResult<Object>(false, ResultEnum.INVALID_USER.getMsg());
		}
		try {
			User user = userService.userLogin(userPhone);
			if(user==null){
				return new BaseResult<Object>(false, ResultEnum.INVALID_USER.getMsg());
			}
			session.setAttribute("user", user);
		} catch (BizException e) {
			return new BaseResult<Object>(false, e.getMessage());
		} catch (Exception e) {
			return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
		}
		return new BaseResult<Object>(true, null);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult<Object> logout(HttpSession session){
		//删除保存用户信息的属性
		session.removeAttribute("user");
		return new BaseResult<Object>(true, null);
	}

}
