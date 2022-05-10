package com.hiringapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component		
public class UserAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private String line = "******";
	
	/**
	 * this method used for logger purpose
	 * advice - before
	 * @param joinPoint
	 */
	@Before("execution(* com.hiringapp.service.UserService+.*(..))")
	public void logBefore(JoinPoint joinPoint) {

		log.info("logBefore() started");
		log.info("Method Name:" + joinPoint.getSignature().getName());
		log.info("logBefore() completed!");
		log.info(line);
	}
	
	@After("execution(* com.hiringapp.service.UserService+.*(..))")
	public void logAfter(JoinPoint joinPoint) {

		log.info("logAfter() started");
		log.info("Method Name:" + joinPoint.getSignature().getName());
		log.info("logAfter() completed!");
		log.info(line);
	}

	@AfterReturning(pointcut = "execution(* com.hiringapp.service.UserService+.*(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		log.info("logAfterReturning() started!");
		log.info("Method Name : " + joinPoint.getSignature().getName());
		log.info("Method returned value is : " + result);
		log.info(line);

	}

	@AfterThrowing(pointcut = "execution(* com.hiringapp.service.UserService+.*(..))", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

		log.info("logAfterThrowing() is running!");
		log.info("Method Signature : " + joinPoint.getSignature().getName());
		log.info("Exception : " + error);
		log.info(line);


	}
}
