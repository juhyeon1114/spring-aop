package hello.springaop;

import hello.springaop.trace.logtrace.FieldLogTrace;
import hello.springaop.trace.logtrace.LogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "hello.springaop.aop")
public class SpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

}
