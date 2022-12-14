package hello.springaop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV1 {

    private CallServiceV1 callServiceV1;

    /**
     * 자기 자신을 주입할 때는, 생성자를 사용할 수 없다. (순환참조)
     * 대신, setter를 사용하자
     */
    @Autowired
    public void setCallServiceV1(CallServiceV1 callServiceV1) {
        this.callServiceV1 = callServiceV1;
    }

    public void external() {
        log.info("call external");
        callServiceV1.internal(); //내부 메서드 호출(this.internal())
    }

    public void internal() {
        log.info("call internal");
    }

}