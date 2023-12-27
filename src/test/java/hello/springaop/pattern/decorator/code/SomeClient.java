package hello.springaop.pattern.decorator.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SomeClient {

    private final Server server;

    public void request() {
        String result = server.run();
        log.info("result={}", result);
    }

}
