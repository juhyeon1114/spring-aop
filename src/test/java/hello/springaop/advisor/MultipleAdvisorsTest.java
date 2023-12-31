package hello.springaop.advisor;

import hello.springaop.common.service.SomeService;
import hello.springaop.common.service.SomeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class MultipleAdvisorsTest {
    @Test
    @DisplayName("여러 프록시 적용 : 프록시 2번 생성")
    public void advisorTest1() throws Exception {
        // 프록시 1 생성
        SomeService service = new SomeServiceImpl();
        ProxyFactory proxyFactory1 = new ProxyFactory(service);
        DefaultPointcutAdvisor advisor1 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice1());
        proxyFactory1.addAdvisor(advisor1);
        SomeService proxy1 = (SomeService) proxyFactory1.getProxy();

        // 프록시 2 생성
        ProxyFactory proxyFactory2 = new ProxyFactory(proxy1);
        DefaultPointcutAdvisor advisor2 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice2());
        proxyFactory2.addAdvisor(advisor2);
        SomeService proxy2 = (SomeService) proxyFactory2.getProxy();

        // 실행
        proxy2.save();
    }

    @Test
    @DisplayName("여러 프록시 적용 : 프록시 1번 생성")
    public void advisorTest2() throws Exception {
        // Advisor 생성
        DefaultPointcutAdvisor advisor1 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice1());
        DefaultPointcutAdvisor advisor2 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice2());

        // 프록시 생성
        SomeService service = new SomeServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(service);
        proxyFactory.addAdvisor(advisor2);
        proxyFactory.addAdvisor(advisor1);

        SomeService proxy = (SomeService) proxyFactory.getProxy();

        proxy.save();
    }

    @Slf4j
    static class Advice1 implements MethodInterceptor {

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            log.info("Advice1");
            return invocation.proceed();
        }
    }

    @Slf4j
    static class Advice2 implements MethodInterceptor {

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            log.info("Advice2");
            return invocation.proceed();
        }
    }
}
