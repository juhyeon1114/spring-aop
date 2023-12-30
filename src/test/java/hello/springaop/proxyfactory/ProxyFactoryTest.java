package hello.springaop.proxyfactory;

import hello.springaop.common.advice.TimeAdvice;
import hello.springaop.common.service.NotImplementedService;
import hello.springaop.common.service.SomeService;
import hello.springaop.common.service.SomeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

@Slf4j
public class ProxyFactoryTest {
    
    @Test
    @DisplayName("JDK 동적 프록시 사용")
    public void useJDKDynamicProxy() throws Exception {
        SomeService service = new SomeServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(service);
//        proxyFactory.setProxyTargetClass(true); // 이 값이 true이면, JDK 동적 프록시 대신 CGLIB를 무조건 사용한다.

        proxyFactory.addAdvice(new TimeAdvice());
        SomeService proxy = (SomeService) proxyFactory.getProxy();

        log.info("originalClass={}", service.getClass());
        log.info("proxyClass={}", proxy.getClass());
        log.info("프록시 팩토리를 활용한 프록시인가? {}", AopUtils.isAopProxy(proxy));
        log.info("JDK 동적 프록시를 활용한 프록시인가? {}", AopUtils.isJdkDynamicProxy(proxy));
        log.info("CGLIB을 활용한 프록시인가? {}", AopUtils.isCglibProxy(proxy));

        proxy.find();
    }

    @Test
    @DisplayName("CGLIB 사용")
    public void useCGLIBProxy() throws Exception {
        NotImplementedService service = new NotImplementedService();
        ProxyFactory proxyFactory = new ProxyFactory(service);

        proxyFactory.addAdvice(new TimeAdvice());
        NotImplementedService proxy = (NotImplementedService) proxyFactory.getProxy();

        log.info("originalClass={}", service.getClass());
        log.info("proxyClass={}", proxy.getClass());
        log.info("프록시 팩토리를 활용한 프록시인가? {}", AopUtils.isAopProxy(proxy));
        log.info("JDK 동적 프록시를 활용한 프록시인가? {}", AopUtils.isJdkDynamicProxy(proxy));
        log.info("CGLIB을 활용한 프록시인가? {}", AopUtils.isCglibProxy(proxy));

        proxy.find();
    }
    
}
