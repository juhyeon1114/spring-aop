package hello.springaop.aopInternalCall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SomeService {

    public void external() {
        log.info("SomeService.external()");
        internal();
    }

    public void internal() {
        log.info("SomeService.internal()");
    }

}
