package hello.springaop.v5autoproxy;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Around("execution(* hello.springaop.v5autoproxy..find(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        String message = joinPoint.getSignature().toShortString();
        Object result = joinPoint.proceed();
        log.info("LogAspet={}", message);
        return result;
    }

}
