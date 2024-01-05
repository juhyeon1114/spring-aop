package hello.springaop.aopInternalCall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 구조 변경 분리
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SomeServiceV3 {

    private final InternalService internalService;

    public void external() {
        log.info("SomeServiceV3.external()");
        internalService.internal();
    }

}
