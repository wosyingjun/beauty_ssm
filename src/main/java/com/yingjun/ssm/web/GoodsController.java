package com.yingjun.ssm.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yingjun.ssm.dto.BaseResult;
import com.yingjun.ssm.dto.OrderResultDto;
import com.yingjun.ssm.entity.Goods;
import com.yingjun.ssm.entity.Order;
import com.yingjun.ssm.enums.ResultEnum;
import com.yingjun.ssm.exception.MyException;
import com.yingjun.ssm.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, Integer offset, Integer limit) {
		LOG.info("invoke----------/goods/list");
		offset = offset == null ? 0 : offset;//默认便宜0
		limit = limit == null ? 50 : limit;//默认展示50条
		List<Goods> list = goodsService.getGoodsList(offset, limit);
		model.addAttribute("goodslist", list);
		return "goodslist";
	}
	
	@RequestMapping(value = "/{goodsId}/buy", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public BaseResult<Object> buy(@CookieValue(value = "userPhone", required = false) Long userPhone,
			@PathVariable("goodsId") Long goodsId){
		LOG.info("invoke----------/"+goodsId+"/buy userPhone:"+userPhone);
		if (userPhone == null||goodsId==null) {
			return new BaseResult<Object>(false, ResultEnum.PARAM_USER.getMsg());
		}
		try {
			goodsService.buyGoods(userPhone, goodsId, false);
		}catch (MyException e1) {
			return new BaseResult<Object>(false, e1.getMessage());
		}catch (Exception e) {
			return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
		}
		return new BaseResult<Object>(true, "success");
	}
}
