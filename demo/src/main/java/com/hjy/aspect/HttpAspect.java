package com.hjy.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hjy
 * @create 2018/05/12
 **/
@Aspect
@Component
public class HttpAspect {
	private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

	@Pointcut("execution(public * com.hjy.controller.UserController.*(..))")
	public void getList() {
	}

	@Before("getList()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes =
				(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		//url
		logger.info("usr={}", request.getRequestURL());

		//method
		logger.info("method={}", request.getMethod());

		//ip
		logger.info("ip={}", request.getRemoteAddr());

		//类方法
		logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()
		+ "." + joinPoint.getSignature().getName());

		//参数
		logger.info("args={}", joinPoint.getArgs());

		logger.info("处理前");
	}

	@After("getList()")
	public void doAfter() {
		logger.info("处理后");
	}
	@AfterReturning(returning = "object", pointcut = "getList()")
	public void doAfterReturning(Object object) {
		logger.info("response={}", object);
	}
}
