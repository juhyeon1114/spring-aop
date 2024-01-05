package hello.springaop.aopInternalCall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 지연 로딩
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SomeServiceV2 {

    private final ApplicationContext ac;
    private final ObjectProvider<SomeServiceV2> serviceProvider;

    public void external() {
        log.info("SomeServiceV2.external()");

        SomeServiceV2 serviceV2 = serviceProvider.getObject();
        serviceV2.internal();
//        SomeServiceV2 someServiceV2 = ac.getBean(SomeServiceV2.class);
//        someServiceV2.internal();
    }

    public void internal() {
        log.info("SomeServiceV2.internal()");
    }

}
