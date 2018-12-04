package com.springtesting.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CountryControllerLogging
{
    private Logger log= LoggerFactory.getLogger(AddressLogging.class);
    @Pointcut("execution(* com.springtesting.web.api.*.*(..))")
    public void getCountries() {}

    @Before("getCountries()")
    public void beforeAdvice()
    {
        log.warn("Log Message: Inside beforeAdvice() advice");
    }

    @After("getCountries()")
    public void afterAdvice()
    {
        log.warn("Log Message: Inside afterAdvice() advice");
    }
}
