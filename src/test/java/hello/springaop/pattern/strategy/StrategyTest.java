package hello.springaop.pattern.strategy;

import hello.springaop.pattern.strategy.code.Context;
import hello.springaop.pattern.strategy.code.Strategy1;
import hello.springaop.pattern.strategy.code.Strategy2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class StrategyTest {

    @Test
    @DisplayName("strategyTest")
    public void strategyTest() throws Exception {
        Strategy1 strategy1 = new Strategy1();
        Strategy2 strategy2 = new Strategy2();

        Context context1 = new Context(strategy1);
        Context context2 = new Context(strategy2);

        context1.execute();
        context2.execute();
    }

}
