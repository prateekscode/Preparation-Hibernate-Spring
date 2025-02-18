package com.springaop.learn_springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

	@Pointcut("execution(* com.springaop.learn_springaop.data.*.*(..))")
	public void dataLayerExecution() {	
	}
	
	@Pointcut("execution(* com.springaop.learn_springaop.business.*.*(..))")
	public void businessLayerExecution() {	
	}
	
	@Pointcut("@annotation(com.springaop.learn_springaop.data.TrackTime)")
	public void trackTimeAnnotation() {
	}
}
