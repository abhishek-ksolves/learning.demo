package com.learning.demo.aspect;

import com.learning.demo.entities.Customer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerAspect {

    Logger logger = LoggerFactory.getLogger(Customer.class);

//    @Before(value = "execution(* com.learning.demo.service.CustomerCrudOperationService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        logger.info(joinPoint.getArgs().toString());
        logger.info("JoinPoint.........................");
    }
//    @Before(value = "execution(* com.learning.demo.service.CustomerLoginService.*(..))")
    public void customerAdvice(JoinPoint joinPoint){
        logger.info(joinPoint.getArgs().toString());
        logger.info("JoinPoint.........................");
    }

//    @Pointcut(value = "execution(* com.learning.demo.service.CustomerCrudOperationService.*(..))")
//    public void display(JoinPoint joinPoint){
//        logger.info("*******PointCut******");
//    }

//    @Around(value="display()")
//    public void aroundAdvice(ProceedingJoinPoint jp) throws Throwable{
//        try{
//            jp.proceed();
//        }
//        finally {
//            logger.info(jp.toString());
//        }
//    }
}
