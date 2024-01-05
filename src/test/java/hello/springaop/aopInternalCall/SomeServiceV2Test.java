package hello.springaop.aopInternalCall;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SomeServiceV2Test {

    @Autowired
    SomeServiceV2 service;

    @Test
    @DisplayName("external 호출")
    public void externalCallTest() throws Exception {
        service.external();
    }

    @Test
    @DisplayName("internal 호출")
    public void internalCallTest() throws Exception {
        service.internal();
    }

}