package hello.springaop.dynamicjdk.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
@RequiredArgsConstructor
public class TimeInvocationHandler implements InvocationHandler {

    private final Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("TimeProxy 실행");
        long startMs = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long endMs = System.currentTimeMillis();
        long resultMs = endMs - startMs;
        log.info("TimeProxy 종료 : {}ms", resultMs);
        return result;
    }
}
