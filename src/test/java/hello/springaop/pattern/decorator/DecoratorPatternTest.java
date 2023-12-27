package hello.springaop.pattern.decorator;

import hello.springaop.pattern.decorator.code.MessageDecorator;
import hello.springaop.pattern.decorator.code.RealServer;
import hello.springaop.pattern.decorator.code.SomeClient;
import hello.springaop.pattern.decorator.code.TimeDecorator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {

    @Test
    @DisplayName("데코레이터 미적용")
    public void noDecorator() throws Exception {
        RealServer realComponent = new RealServer();
        SomeClient client = new SomeClient(realComponent);

        client.request();
    }

    @Test
    @DisplayName("데코데이터 적용")
    public void decorator() throws Exception {
        RealServer realComponent = new RealServer();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);
        SomeClient client = new SomeClient(timeDecorator);

        client.request();
    }

}
