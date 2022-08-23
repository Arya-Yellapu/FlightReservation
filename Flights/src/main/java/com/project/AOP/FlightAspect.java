package com.project.AOP;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FlightAspect {

Logger logger = LoggerFactory.getLogger(this.getClass());

@AfterThrowing(pointcut="execution(* com.project.Service.FlightServiceImpl.*(..))",throwing="Exception")
public void ServiceExceptions(Exception Exception)
{
	logger.error(Exception.getMessage());
}

@AfterThrowing(pointcut="execution(* com.project.DAO.FlightDAOImpl.*(..))",throwing="Exception")
public void DAOExceptions(Exception Exception)
{
	logger.error(Exception.getMessage());
}
	
}
