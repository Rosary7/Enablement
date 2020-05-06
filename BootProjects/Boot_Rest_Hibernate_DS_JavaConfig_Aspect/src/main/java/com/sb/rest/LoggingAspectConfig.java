package com.sb.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/*
 * Using AOP for logging.
 * 
 * Maven dependency:
 * <dependency>
 * 		<groupId>org.springframework.boot</groupId>
 * 		<artifactId>spring-boot-starter-aop</artifactId>
 * </dependency>
 * 
 *  It imports spring-aop and aspectjweaver dependencies into the application.
 * 
 *  This is tested in UserController.java
 */

@Aspect
@Component
public class LoggingAspectConfig {
	private static final Logger LOGGER = LogManager.getLogger(LoggingAspectConfig.class);

	// This advice will be executed around all calls to public methods of classes from the com.sb.rest package.
	// ProceedingJoinPoint to get the method name for our join point.
	@Around("execution(* com.sb.rest..*(..)))")
	public Object profileAllMethods(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		// Get the intercepted method details
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();		
		Object result = joinPoint.proceed();

		// Log  executing method name
		LOGGER.info("...Logging  using AOP @Around Advice ... : " + methodName);

		return result;
	}
	/*
	 Where-
		1. @Before   : The code written in this is executed before calling of actual method
		2. *	          : It applies on all methods having return type (use 'void', return type is void)
		3. com.sb.rest..*: it applies on all classes which resides under com.sb.rest package and
		4. add*(*)	: all methods which starts with 'add' word (ie: addUser) and (*) denotes method having only one argument.
	
	 */
	@Before("execution(* com.sb.rest.*.add*(*))")
    public void callSetters(JoinPoint joinPoint) {
		LOGGER.info("...Logging  using AOP @@Before Advice ... : " +"Method Invoked: " + joinPoint.getSignature().getName());
		LOGGER.info("...Logging  using AOP @@Before Advice ... : " +"Param value Passed: " + joinPoint.getArgs()[0].toString());
    }
}
