package hello.springaop.trace.hellotrace;

import hello.springaop.trace.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV1Test {

    @Test
    @DisplayName("begin_end")
    public void begin_end() throws Exception {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("Hello world");
        trace.end(status);
    }

    @Test
    @DisplayName("begin_exception")
    public void begin_exception() throws Exception {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("Hello world");
        trace.exception(status, new IllegalStateException());
    }

}