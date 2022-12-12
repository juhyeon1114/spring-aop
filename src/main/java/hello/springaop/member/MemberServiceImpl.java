package hello.springaop.member;

import hello.springaop.member.annotation.ClassAop;
import hello.springaop.member.annotation.MethodAop;
import org.springframework.stereotype.Component;

@ClassAop
@Component
public class MemberServiceImpl implements MemberService {

    @MethodAop("test value")
    @Override
    public String hello(String name) {
        return "ok";
    }

    public String internal(String param) {
        return "ok";
    }

}
