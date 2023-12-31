package hello.springaop.v5autoproxy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class AutoProxyConfig {

    private final TimeAdvice timeAdvice;

//    @Bean
    public Advisor advisor1() {
        // Pointcut
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("hello*", "save*");

        // Advice
        return new DefaultPointcutAdvisor(pointcut, timeAdvice);
    }

    @Bean
    public Advisor advisor2() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* hello.springaop.v5autoproxy..save(..))");

        return new DefaultPointcutAdvisor(pointcut, timeAdvice);
    }
}