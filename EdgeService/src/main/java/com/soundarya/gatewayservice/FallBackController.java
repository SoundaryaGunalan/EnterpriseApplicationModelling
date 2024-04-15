package com.soundarya.gatewayservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @GetMapping("/fallback")
    Flux<String> fallbackMethod(){
        return Flux.just("The service is not running properly. Please try again later");
    }
}
