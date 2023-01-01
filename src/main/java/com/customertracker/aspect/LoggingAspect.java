package com.customertracker.aspect;


import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private Logger logger=Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(String com.customertracker.controller.*.*(..))")
	private void forControllerPackage() {};

	@Pointcut("execution(* com.customertracker.service.*.*(..))")
	private void forServicePackage() {};

	@Pointcut("execution(* com.customertracker.dao.*.*(..))")
	private void forDAOPackage() {};

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {};
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		logger.info("==>> Calling Method: "+joinPoint.getSignature().toShortString());
	}
	
	@AfterReturning(pointcut = "forAppFlow()",returning = "result")
	public void before(JoinPoint joinPoint,Object result) {
		logger.info("==>> Method Completed: "+joinPoint.getSignature().toShortString());
	}
}
