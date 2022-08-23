package com.project.AOP;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GoogleUserAspect {
	
Logger logger = LoggerFactory.getLogger(this.getClass());

@AfterThrowing(pointcut="execution(* com.project.DAO.GoogleUserDAOImpl.*(..))",throwing="exception")
public void daoExceptions(Exception exception)
{
	logger.error(exception.getMessage());
}

@AfterThrowing(pointcut="execution(* com.project.Service.GoogleUserServiceImpl.*(..))",throwing="exception")
public void serviceExceptions(Exception exception)
{
	logger.error(exception.getMessage());
}
	
}
