package hello.springaop.section4.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderServiceV1;

    @GetMapping("/request")
    String request(@RequestParam("itemId") String itemId) {
        orderServiceV1.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/no-log")
    String noLog() {
        return "no-log";
    }

}
