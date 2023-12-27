package hello.springaop.pattern.strategy.code;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Context {

    private Strategy strategy;

    public void execute() {
        long startMs = System.currentTimeMillis();
        strategy.run();
        long endMs = System.currentTimeMillis();
        log.info("SpendMs={}", endMs - startMs);
    }

}
