package com.ninja.utility;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Component
@Aspect
public class LoggingAspect {
	
	public static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);
	@AfterThrowing(pointcut = "execution(* com.ninja.service.*Impl.*(..))", throwing = "exception")
	
	public void logServiceException(Exception exception) {
		LOGGER.error(exception.getMessage(), exception);
	}
	
	@AfterThrowing(pointcut = "execution(* com.ninja.repository.*Impl.*(..))", throwing = "exception")
	public void logRepositoryException(Exception exception) {
		LOGGER.error(exception.getMessage(), exception);
	}
}
