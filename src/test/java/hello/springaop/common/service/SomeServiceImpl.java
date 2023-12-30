package hello.springaop.common.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SomeServiceImpl implements SomeService {
    @Override
    public void find() {
        log.info("SomeService.find()");
    }
}
