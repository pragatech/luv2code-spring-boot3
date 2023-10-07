package com.praga.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //This is where we are all add our advises.

    //we are mentioning pointcut expression within quotes
    //@Before("execution(public void com.praga.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(* add*())")
    //@Before("execution(* add*(com.praga.aopdemo.Account, ..))")
    @Before("execution(* com.praga.aopdemo.test..*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=======>> Executing @Before Advice on adding Account");
    }

}
