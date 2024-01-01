package hello.springaop.aopInternalCall;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Before("execution(* hello.springaop.aopInternalCall..*.*(..))")
    public void doLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        log.info("signature={}", signature);
    }

}
