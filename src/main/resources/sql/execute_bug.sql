-- 买逻辑的存储过程
DELIMITER $$ -- 结束标志;转换为 $$
-- 定义存储过程
-- 参数：in 输入参数; out 输出参数
-- row_count():返回上一条修改类型sql(delete,insert,upodate)的影响行数
-- row_count: 0:未修改数据; >0:表示修改的行数; <0:sql错误/未执行修改sql
CREATE PROCEDURE `beauty_ssm`.`execute_buy`
(IN  v_user_id BIGINT, 
 IN  v_goods_id BIGINT,
 IN  v_title VARCHAR(120), 
 OUT r_result INT)
	BEGIN
		DECLARE insert_count INT DEFAULT 0;
		START TRANSACTION;
		INSERT INTO _order (user_id, goods_id, title)
		VALUES(v_user_id, v_goods_id, v_title);
		SELECT ROW_COUNT() INTO insert_count;
		IF (insert_count = 0) THEN
			ROLLBACK;
			SET r_result = -1;
		ELSEIF (insert_count < 0) THEN
			ROLLBACK ;
			SET r_result = -2;
		ELSE
			UPDATE _goods SET number = number - 1
			WHERE goods_id = v_goods_id 
			AND number > 0;
			SELECT ROW_COUNT() INTO insert_count;
			IF (insert_count = 0) THEN
				ROLLBACK;
				SET r_result = 0;
			ELSEIF (insert_count < 0) THEN
				ROLLBACK;
				SET r_result = -2; 
			ELSE
				COMMIT;
			SET r_result = 1;
			END IF;
		END IF;
	END;
$$
-- 代表存储过程定义结束


DELIMITER ; -- 结束标志换回默认的;
SET @r_result = -3;
-- 执行存储过程
call execute_buy(1000,1000,'抢购iphone', @r_result);
-- 获取结果
SELECT @r_result;

-- 存储过程
-- 1.存储过程优化：事务行级锁持有的时间
-- 2.不要过度依赖存储过程
-- 3.简单的逻辑可以应用存储过程
-- 4.QPS:一个秒杀单6000/qps

