package com.yingjun.ssm.quartz;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yingjun.ssm.cache.RedisCache;
import com.yingjun.ssm.dao.UserDao;

/**
 * 业务相关的作业调度
 * 
           字段               允许值                           允许的特殊字符
	秒	 	0-59	 	, - * /
	分	 	0-59	 	, - * /
	小时	 	0-23	 	, - * /
	日期	 	1-31	 	, - * ? / L W C
	月份	 	1-12 或者 JAN-DEC	 	, - * /
	星期	 	1-7 或者 SUN-SAT	 	, - * ? / L C #
	年（可选）	 	留空, 1970-2099	 	, - * /
	
	*  字符代表所有可能的值
	/  字符用来指定数值的增量
	L  字符仅被用于天（月）和天（星期）两个子表达式，表示一个月的最后一天或者一个星期的最后一天
	6L 可以表示倒数第６天
	
 * @author yingjun
 *
 */
@Component
public class BizQuartz {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserDao userDao;
	@Autowired
	private RedisCache cache;
	
	/**
	 * 用户自动加积分
	 * 每天9点到17点每过1分钟所有用户加一次积分
	 */
	@Scheduled(cron = "0 0/1 9-17 * * ? ")
	public void addUserScore() {
		LOG.info("@Scheduled--------addUserScore()");
		userDao.addScore(10);
	}
	/**
	 * 每隔5分钟定时清理缓存
	 */
	@Scheduled(cron = "0 0/5 * * * ? ")
	public void cacheClear() {
		LOG.info("@Scheduled-------cacheClear()");
		cache.clearCache();
	}
	
}
