package com.yingjun.ssm.exception;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.alibaba.fastjson.JSON;
import com.yingjun.ssm.dto.BaseResult;

/**
 * 错误信息统一处理
 * 对未处理的错误信息做一个统一处理
 * @author yingjun
 *
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@ResponseBody
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		LOG.error("用户 " + WebUtils.getCookie(request, "userPhone").getValue() + " 访问" + request.getRequestURI() + " 发生错误, 错误信息:" + ex.getMessage());
		//这里有2种选择
		//跳转到定制化的错误页面
	    /*ModelAndView error = new ModelAndView("error");
		error.addObject("exMsg", ex.getMessage());
		error.addObject("exType", ex.getClass().getSimpleName().replace("\"", "'"));*/
		//返回json格式的错误信息
		try {
			PrintWriter writer = response.getWriter();
			BaseResult<String> result=new BaseResult(false, ex.getMessage());
			writer.write(JSON.toJSONString(result));
			writer.flush();
		} catch (Exception e) {
		}
		return null;
	}
	

}
