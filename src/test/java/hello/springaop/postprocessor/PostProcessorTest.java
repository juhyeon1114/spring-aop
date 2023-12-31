package hello.springaop.postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class PostProcessorTest {

    @Test
    @DisplayName("basicConfig")
    public void basicConfig() throws Exception {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PostProcessorConfig.class);

        A a = ac.getBean("beanA", A.class);
        a.helloA();
    }

    @Slf4j
    @Configuration
    static class PostProcessorConfig {
        @Bean(name = "beanA")
        public A a() {
            return new A();
        }

        @Bean(name = "beanB")
        public B b() {
            return new B();
        }

        @Bean
        public AtoBPostProcessor aToBPostProcessor() {
            return new AtoBPostProcessor();
        }
    }

    @Slf4j
    static class A {
        public void helloA() {
            log.info("hello A");
        }
    }

    @Slf4j
    static class B {
        public void helloB() {
            log.info("hello B");
        }
    }

    @Slf4j
    static class AtoBPostProcessor implements BeanPostProcessor {

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) {
            log.info("beanName={} bean={}", beanName, bean);
            if (bean instanceof A) {
                return new B();
            }
            return bean;
        }

    }

}
