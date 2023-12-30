package hello.springaop.dynamicjdk;

import hello.springaop.dynamicjdk.code.AImpl;
import hello.springaop.dynamicjdk.code.AInterface;
import hello.springaop.dynamicjdk.code.TimeInvocationHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkProxyTest {

    @Test
    @DisplayName("A")
    public void A() throws Exception {
        AInterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        // 동적으로 프록시 객체 생성
        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);
        proxy.call();

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }

}
