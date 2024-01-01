package hello.springaop.aop.order.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* hello.springaop.aop.order..*(..))")
    public void orderPackage() {}

    @Pointcut("execution(* *..*Service.*(..))")
    public void allService(){}

    @Pointcut("allService() && orderPackage()")
    public void orderService(){}

}
