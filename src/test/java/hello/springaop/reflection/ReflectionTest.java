package hello.springaop.reflection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    /**
     * 리플렉션은 런타임에서 코드를 핸들링 하므로 컴파일 과정에서 에러를 잡을 수 없어서 가급적이면 사용하지 않는 것이 좋다.
     */

    @Test
    @DisplayName("noReflection")
    public void noReflection() throws Exception {
        HelloReflection helloReflection = new HelloReflection();

        String result1 = helloReflection.callA();
        log.info("result={}", result1);

        String result2 = helloReflection.callB();
        log.info("result={}", result2);
    }

    @Test
    @DisplayName("reflectionBasic")
    public void reflectionBasic() throws Exception {
        Class<?> classHello = Class.forName("hello.springaop.reflection.HelloReflection"); // 클래스의 메타 정보 획득

        HelloReflection helloReflection = new HelloReflection();

        Method methodCallA = classHello.getMethod("callA"); // 메서드의 메타 정보 획득
        Object result1 = methodCallA.invoke(helloReflection);
        log.info("result={}", result1);

        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(helloReflection);
        log.info("result={}", result2);
    }

    @Test
    @DisplayName("reflectionDynamic - 동적으로 코드 조작이 가능하다")
    public void reflectionDynamic() throws Exception {
        Class<?> classHello = Class.forName("hello.springaop.reflection.HelloReflection");

        HelloReflection helloReflection = new HelloReflection();

        Method methodCallA = classHello.getMethod("callA");
        dynamicCall(methodCallA, helloReflection);

        Method methodCallB = classHello.getMethod("callB");
        dynamicCall(methodCallB, helloReflection);
    }

    private void dynamicCall(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        Object result = method.invoke(target);
        log.info("result={}", result);
    }

}
