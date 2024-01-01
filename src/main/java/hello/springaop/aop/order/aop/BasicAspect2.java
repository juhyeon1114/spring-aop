package hello.springaop.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
public class BasicAspect2 {

    @Aspect
    @Order(2)
    @Component
    public static class LogAspect {
        @Around("hello.springaop.aop.order.aop.Pointcuts.orderPackage()")
        public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
            Signature signature = joinPoint.getSignature();
            log.info("[Call] {}", signature);
            return joinPoint.proceed();
        }
    }

    @Aspect
    @Order(1)
    @Component
    public static class TxAspect {
        @Around("hello.springaop.aop.order.aop.Pointcuts.orderService()")
        public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
            Signature signature = joinPoint.getSignature();
            try {
                log.info("[Transaction start] {}", signature);
                Object result = joinPoint.proceed();
                log.info("[Transaction end] {}", signature);
                return result;
            } catch (Exception e) {
                log.info("[Transaction rollback] {}", signature);
                throw e;
            }
        }
    }

}
