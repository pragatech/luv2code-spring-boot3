package com.praga.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//Note: if we are adding only pointcuts, aspects are optional.
//It is not necessary to declare for taking effect. it required when we are
//using advices
@Aspect
public class PragaAOPExpressions {
    //This is where we are all add our advises.
    @Pointcut("execution(* com.praga.aopdemo.test..*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.praga.aopdemo.test..get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.praga.aopdemo.test..set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

}
