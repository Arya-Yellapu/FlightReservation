package com.infy.Utility;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.infy.DAO.*;
import com.infy.Service.*;

@Aspect
@Component
public class CardAOP {

Logger logger = LoggerFactory.getLogger(this.getClass());

@AfterThrowing(pointcut="execution( * com.infy.DAO.CardDAOImpl.*(..))",throwing="exception")
public void daoException(Exception exception)
{
	logger.error(exception.getMessage());
}

@AfterThrowing(pointcut="execution( * com.infy.Service.CardServiceImpl.*(..))",throwing="exception")
public void serviceException(Exception exception)
{
	logger.error(exception.getMessage());
}
}
