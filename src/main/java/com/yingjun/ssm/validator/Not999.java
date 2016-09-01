package com.yingjun.ssm.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 自定义validator标签(和 hibernate validator组合使用)
 * 
 * @author yingjun
 *
 */
@Constraint(validatedBy = Not999Validator.class) // 具体的实现
@Target({ java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD })
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
public @interface Not999 {

	// 提示信息,可以写死,可以填写国际化的key
	String message() default "{com.yingjun.ssm.validator.not999}";

	// 下面这两个属性必须添加
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
