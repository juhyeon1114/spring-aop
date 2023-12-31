package hello.springaop.autoproxy;

import hello.springaop.v5autoproxy.SomeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class AutoProxyTest {

    @Autowired
    private SomeService someService;

    @Test
    @DisplayName("AutoProxyTest")
    public void autoProxyTest() throws Exception {
        someService.find();
        someService.save();
    }
}
