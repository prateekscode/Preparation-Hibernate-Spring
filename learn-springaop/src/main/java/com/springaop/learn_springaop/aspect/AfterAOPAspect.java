package com.springaop.learn_springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//Aop
//configuration
@Aspect
@Configuration
public class AfterAOPAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// this will return only when the execution will get completed successfully
	@AfterReturning(value = "com.springaop.learn_springaop.aspect.CommonJoinPointConfig.businessLayerExecution()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("after returning {} returned value {}", joinPoint, result);
	}

//	if want to intercept some exception show we can use 
	@AfterThrowing(value = "execution(* com.springaop.learn_springaop.business.*.*(..))", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Object exception) {
		logger.info("{} returned value {}", joinPoint, exception);
	}
	
//	we can use this for both the cases
	@After(value = "execution(* com.springaop.learn_springaop.business.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("after execution of {}", joinPoint);
	}
}
