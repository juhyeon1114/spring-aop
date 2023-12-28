package hello.springaop.jdkdynamic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloReflection {
    public String callA() {
        log.info("A");
        return "A";
    }

    public String callB() {
        log.info("B");
        return "B";
    }
}
