package com.springtesting.aop;

import com.springtesting.model.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Aspect
@Configuration
public class ProductLogging
{
    private Logger log= LoggerFactory.getLogger(ProductLogging.class);

    @Pointcut("execution(* com.springtesting.repo.ProductRepository.*(..))")
    //@Pointcut("execution(* com.springtesting.repo.*.*(..))")
    //@Pointcut("within(com.springtesting.repo.ProductRepository)")
    public void selectGetProducts() {}

    @After("selectGetProducts()")
    public void afterAdvice()
    {
        log.info("Log Message: After Advice Executed");
    }

    @Before("selectGetProducts()")
    public void beforeAdvice()
    {
        log.info("Log Message: Before Advice Executed");
    }


    @AfterReturning(pointcut="execution(* com.springtesting.repo.*.*(..))",returning = "returnProducts")
    public void afterAdviceGetProducts(JoinPoint jp, List<Product> returnProducts)
    {
        log.info("Log Message: After afterAdviceGetProducts() executed");
        for (Product product: returnProducts)
        {
            log.info("Log Message: Product => "+product.toString());
        }
    }

    @AfterThrowing(pointcut="execution(* com.springtesting.repo.*.*(..))",throwing = "error")
    public void afterThrowingAdvice(JoinPoint jp,Throwable error)
    {
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Exception: "+error);
    }

}
