package hello.springaop.dynamicjdk.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AImpl implements AInterface {
    @Override
    public String call() {
        log.info("A");
        return "A";
    }
}
