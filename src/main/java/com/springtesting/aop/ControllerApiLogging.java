package com.springtesting.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ControllerApiLogging
{
    private Logger log = LoggerFactory.getLogger(ControllerApiLogging.class);


    @Before("execution(* com.springtesting.web.api.*.*(..))")
    public void beforeAdvice()
    {
        log.warn("ControllerApiLogging=> Log Message: Inside beforeAdvice() advice");
    }

    @After("execution(* com.springtesting.web.api.*.*(..))")
    public void afterAdvice()
    {
        log.warn("ControllerApiLogging=> Log Message: Inside afterAdvice() advice");
    }
}
