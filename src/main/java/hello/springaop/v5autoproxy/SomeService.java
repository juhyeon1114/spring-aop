package hello.springaop.v5autoproxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SomeService {
    public void find() {
        log.info("SomeService.find()");
    }

    public void save() {
        log.info("SomeService.save()");
    }
}
