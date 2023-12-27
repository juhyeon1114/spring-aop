package hello.springaop.pattern.proxy.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CacheServer implements Server {

    private final Server server;
    private String cacheValue;

    @Override
    public String run() {
        log.info("프록시 서버 호출");
        return cacheValue == null ? server.run() : cacheValue;
    }
}
