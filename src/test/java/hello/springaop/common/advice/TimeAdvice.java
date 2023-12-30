package hello.springaop.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("TimeAdvice.invoke() 실행");
        long startMs = System.currentTimeMillis();

        Object target = invocation.proceed(); // 타겟 클래스를 호출

        long endMs = System.currentTimeMillis();
        log.info("TimeAdvice.invoke() 종료 {}ms", endMs - startMs);
        return target;
    }
}
