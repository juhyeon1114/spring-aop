package hello.springaop.pattern.decorator.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MessageDecorator implements Server {

    private final Server server;

    @Override
    public String run() {
        log.info("MessageDecorator 실행");
        String result = server.run();
        String decoratedResult = "***" + result + "***";
        return decoratedResult;
    }
}
