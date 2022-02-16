package com.nhnent.apigw.test.apigwtestapi.web;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.Assert.*;

@Slf4j
public class TargetApiControllerTest {

    @Test
    public void test() {
        TestWrapBean test = null;

        log.info("Value={}", Optional.ofNullable(test)
                                     .map(TestWrapBean::getTestWrap1)
                                     .map(TestBean::getT1)
                                     .orElse(-100));

    }

    @Data
    public static class TestWrapBean {
        private TestBean testWrap1;
    }

    @Data
    public static class TestBean {
        private Integer t1;
    }
}