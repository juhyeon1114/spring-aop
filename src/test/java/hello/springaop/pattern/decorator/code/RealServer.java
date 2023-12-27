package hello.springaop.pattern.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealServer implements Server {
    @Override
    public String run() {
        log.info("RealServer 실행");
        return "Data";
    }
}
