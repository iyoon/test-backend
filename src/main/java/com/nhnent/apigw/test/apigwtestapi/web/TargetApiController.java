package com.nhnent.apigw.test.apigwtestapi.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class TargetApiController {

    @RequestMapping(value = {"/**"})
    public Map<String, Object> requestInfo(HttpServletRequest request, HttpServletResponse response) {

        Map<String, String> headers = Collections.list(request.getHeaderNames())
                                                 .stream()
                                                 .collect(Collectors.toMap(h -> h, request::getHeader));

        Map<String, Object> requestInfoMap = new HashMap<>();
        requestInfoMap.put("getRequestURI", request.getRequestURI());
        requestInfoMap.put("getRequestURL", request.getRequestURL());
        requestInfoMap.put("getCookies", request.getCookies());
        requestInfoMap.put("getQueryString", request.getQueryString());
        requestInfoMap.put("getParameterMap", request.getParameterMap());
        requestInfoMap.put("headers", headers);

        return requestInfoMap;

    }


    @GetMapping("/random-string/{size}")
    public String getRandomString(@PathVariable Integer size) {
        return RandomStringUtils.randomAlphanumeric(size);
    }


    @GetMapping("/error/400")
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String getBadRequest() {
        return "";
    }


    @GetMapping("/error/500")
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public String getInternalError() {
        return "";
    }


    @GetMapping("/error")
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String getThrowException() throws Exception {
        throw new Exception();
    }


    @GetMapping("/get")
    public String get() {
        return RandomStringUtils.randomAlphanumeric(100);
    }


    @GetMapping("/delay-ms/{time}")
    public String getDelayMs(@PathVariable Long time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (Exception e) {
            log.error("getDelayMs sleep throw exception");
        }
        return RandomStringUtils.randomAlphanumeric(100);
    }


    @GetMapping("/delay-sec/{time}")
    public String getDelaySec(@PathVariable Long time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception e) {
            log.error("getDelaySec sleep throw exception");
        }
        return RandomStringUtils.randomAlphanumeric(100);
    }


    @PostMapping("/random-string/{size}")
    public String postRandomString(@PathVariable Integer size) {
        return RandomStringUtils.randomAlphanumeric(size);
    }


    @PostMapping("/delay-ms/{time}")
    public String postDelayMs(@PathVariable Long time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (Exception e) {
            log.error("getDelayMs sleep throw exception");
        }
        return RandomStringUtils.randomAlphanumeric(100);
    }


    @PostMapping("/delay-sec/{time}")
    public String postDelaySec(@PathVariable Long time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception e) {
            log.error("getDelaySec sleep throw exception");
        }
        return RandomStringUtils.randomAlphanumeric(100);
    }

}
