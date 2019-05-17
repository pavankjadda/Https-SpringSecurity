package com.springtesting.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;



@Aspect
@Configuration
public class AddressLogging
{
    private Logger logger = LoggerFactory.getLogger(AddressLogging.class);

    @Pointcut("execution(* com.springtesting.repo.AddressRepository.findAll())")
    public void getAddresses()
    {
        //Pointcut expression
    }

    @After("getAddresses()")
    public void afterAdvice()
    {
        logger.info("Log Message: Inside afterAdvice() advice");
    }

    @AfterReturning(pointcut = "execution(* com.springtesting.repo.AddressRepository.*(..))",returning = "addressList")
    public void afterReturningAdvice(JoinPoint jp, Object addressList)
    {
        logger.info("Method Signature: {}", jp.getSignature());
    }

}
