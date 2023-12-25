package hello.springaop.pattern.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        long startMs = System.currentTimeMillis();
        run();
        long endMs = System.currentTimeMillis();
        log.info("SpendMs={}", endMs - startMs);
    }

    protected abstract void run();

}
