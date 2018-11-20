package com.springtesting.aop;

import com.springtesting.model.Address;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import java.util.List;

@Aspect
@Configuration
public class AddressLogging
{
    private Logger log=LoggerFactory.getLogger(AddressLogging.class);

    @Pointcut("execution(* com.springtesting.repo.AddressRepository.*(..))")
    public void getAddresses() {}

    @After("getAddresses()")
    public void afterAdvice()
    {
        log.error("Log Message: Inside afterAdvice() advice");
    }

    @AfterReturning(pointcut = "execution(* com.springtesting.repo.AddressRepository.*(..))",returning = "addressList")
    public void afterReturningAdvice(JoinPoint jp, Object addressList)
    {
        System.out.println("Method Signature: "  + jp.getSignature());
        Page<Address> pagedAddressList= (Page<Address>) addressList;
        for (Address address:pagedAddressList)
            System.out.println(address.toString());
    }

}
