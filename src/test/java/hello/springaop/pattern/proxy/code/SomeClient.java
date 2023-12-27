package hello.springaop.pattern.proxy.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SomeClient {

    private final Server server;

    public void request() {
        server.run();
    }

}
