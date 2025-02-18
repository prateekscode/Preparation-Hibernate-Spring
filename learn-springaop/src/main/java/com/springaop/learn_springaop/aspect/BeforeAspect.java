package com.springaop.learn_springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//Aop
//configuration
@Aspect
@Configuration
public class BeforeAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	// What kind of method calls we would intercept
	//execution(* PACKAGE.*.*(..))
	// FIRST * AFTER PACKAGE IS ANY CLASS STAR AND SECOND IS ANY METHOD 	
	@Before("com.springaop.learn_springaop.aspect.CommonJoinPointConfig.dataLayerExecution()")
	public void before(JoinPoint joinPoint) {
		logger.info("Intercepted method call - {}",joinPoint);
	}
}
