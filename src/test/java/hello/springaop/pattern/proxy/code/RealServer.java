package hello.springaop.pattern.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealServer implements Server {
    @Override
    public String run() {
        log.info("서버 호출");
        return "Data";
    }
}
