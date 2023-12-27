package hello.springaop.pattern.decorator.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TimeDecorator implements Server {

    private final Server server;

    @Override
    public String run() {
        log.info("TimeDecorator 실행");
        long startMs = System.currentTimeMillis();
        String result = server.run();
        long endMs = System.currentTimeMillis();
        String decoratedResult = result + " " + (endMs - startMs) + "ms";
        return decoratedResult;
    }
}
