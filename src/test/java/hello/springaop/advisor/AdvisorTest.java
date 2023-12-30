package hello.springaop.advisor;

import hello.springaop.common.advice.TimeAdvice;
import hello.springaop.common.service.SomeService;
import hello.springaop.common.service.SomeServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class AdvisorTest {

    @Test
    @DisplayName("advisor 사용하기 - 기본")
    public void advisorTest1() throws Exception {
        SomeService service = new SomeServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(service);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(Pointcut.TRUE, new TimeAdvice());
        proxyFactory.addAdvisor(advisor);

        SomeService proxy = (SomeService) proxyFactory.getProxy();
        proxy.find();
    }

    @Test
    @DisplayName("직접 만든 포인트컷 적용하기")
    public void advisorTest2() throws Exception {
        SomeService service = new SomeServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(service);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(new MyPointcut(), new TimeAdvice());
        proxyFactory.addAdvisor(advisor);

        SomeService proxy = (SomeService) proxyFactory.getProxy();
        proxy.find();
        proxy.save();
    }

    @Test
    @DisplayName("스프링에서 제공하는 포인트컷 적용하기")
    public void advisorTest3() throws Exception {
        SomeService service = new SomeServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(service);
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("save");
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, new TimeAdvice());
        proxyFactory.addAdvisor(advisor);

        SomeService proxy = (SomeService) proxyFactory.getProxy();
        proxy.find();
        proxy.save();
    }

}
