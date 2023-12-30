package hello.springaop.common.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SomeServiceImpl implements SomeService {
    @Override
    public void find() {
        log.info("SomeService.find()");
    }

    @Override
    public void save() {
        log.info("SomeService.save()");
    }
}
