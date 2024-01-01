package hello.springaop.aopInternalCall;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SomeServiceTest {

    @Autowired
    SomeService someService;

    @Test
    @DisplayName("external 호출")
    public void externalCallTest() throws Exception {
        someService.external();
    }

    @Test
    @DisplayName("internal 호출")
    public void internalCallTest() throws Exception {
        someService.internal();
    }

}