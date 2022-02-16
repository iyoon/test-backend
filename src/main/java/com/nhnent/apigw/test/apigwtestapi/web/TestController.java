package com.nhnent.apigw.test.apigwtestapi.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/test")
    public String test() throws URISyntaxException {

        final RestTemplate restTemplate = new RestTemplate();

        Executor executor = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 10000; i++) {
            executor.execute(() -> {
                try {
                    String resultString = restTemplate.getForObject("http://localhost:11080/random-string/100", String.class);
                    log.info("[{}]: {}", Thread.currentThread().getId(), resultString);
                } catch (Exception e) {
                    log.error("error", e);
                }
            });
        }

        return "OK";
    }
}
