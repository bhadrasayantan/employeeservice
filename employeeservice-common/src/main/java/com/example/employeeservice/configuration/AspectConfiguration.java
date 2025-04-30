package com.example.employeeservice.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectConfiguration {
	Logger LOGGER = LoggerFactory.getLogger(AspectConfiguration.class);
	@Before(value="execution(* com.example.employeeservice.controller..*(..))")
	public void beforeMethod(JoinPoint joinPoint) {
		LOGGER.info("Invoking Method:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		//Arrays.asList(joinPoint.getArgs()).stream().forEach(a->LOGGER.info(a.toString()));
	}
	@AfterReturning(pointcut =  "execution(* com.example.employeeservice.controller..*(..))",returning = "retValue")
	public void afterReturningMethod(JoinPoint joinPoint,Object retValue) {
		LOGGER.info("Completed Method:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		//Arrays.asList(joinPoint.getArgs()).stream().forEach(a->LOGGER.info(a.toString()));
	}
	@AfterThrowing(pointcut="execution(* com.example.employeeservice.controller..*(..))",throwing = "error")
	public void afterThrowingMethod(JoinPoint joinPoint,Throwable error) {
		LOGGER.info("Exception thrown from Method:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		LOGGER.error("Thrown Exception is:"+error.getMessage());
		//Arrays.asList(joinPoint.getArgs()).stream().forEach(a->LOGGER.info(a.toString()));
	}
}
