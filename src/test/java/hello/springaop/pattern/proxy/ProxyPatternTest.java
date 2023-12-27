package hello.springaop.pattern.proxy;

import hello.springaop.pattern.proxy.code.SomeClient;
import hello.springaop.pattern.proxy.code.CacheServer;
import hello.springaop.pattern.proxy.code.RealServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    @DisplayName("프록시 미적용")
    public void noProxy() throws Exception {
        RealServer server = new RealServer();
        SomeClient client = new SomeClient(server);

        client.request();
        client.request();
        client.request();
    }

    @Test
    @DisplayName("프록시 적용")
    public void proxy() throws Exception {
        RealServer realServer = new RealServer();
        CacheServer cacheServer = new CacheServer(realServer);
        SomeClient client = new SomeClient(cacheServer);

        client.request();
        client.request();
        client.request();
    }

}
