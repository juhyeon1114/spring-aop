package hello.springaop.advisor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.MethodMatcher;

import java.lang.reflect.Method;

@Slf4j
public class MyMethodMatcher implements MethodMatcher {
    private String matchMethodName = "save";

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        boolean matched = method.getName().equals(matchMethodName);
        log.info("포인트컷 결과={}", matched);
        return matched;
    }

    @Override
    public boolean isRuntime() {
        return false;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return false;
    }
}
