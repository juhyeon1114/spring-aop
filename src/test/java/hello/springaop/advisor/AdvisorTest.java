package hello.springaop.advisor;

import hello.springaop.common.advice.TimeAdvice;
import hello.springaop.common.service.SomeService;
import hello.springaop.common.service.SomeServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AdvisorTest {

    @Test
    @DisplayName("advisorTest1")
    public void advisorTest1() throws Exception {
        SomeService service = new SomeServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(service);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(Pointcut.TRUE, new TimeAdvice());
        proxyFactory.addAdvisor(advisor);

        SomeService proxy = (SomeService) proxyFactory.getProxy();
        proxy.find();
    }

}
