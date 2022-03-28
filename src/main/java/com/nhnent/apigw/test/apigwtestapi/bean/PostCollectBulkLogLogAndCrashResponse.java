package com.nhnent.apigw.test.apigwtestapi.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostCollectBulkLogLogAndCrashResponse extends DomainResponse {

    public static final PostCollectBulkLogLogAndCrashResponse SUCCESS_RESPONSE = createSuccess();

    private Body body;

    @Getter
    @AllArgsConstructor
    private static class Body {
        private Data data;
    }

    @Getter
    @AllArgsConstructor
    private static class Data {
        private int total;
        private int errors;
        private List<HeaderBean> resultList;
    }


    public static PostCollectBulkLogLogAndCrashResponse createSuccess() {
        PostCollectBulkLogLogAndCrashResponse response = new PostCollectBulkLogLogAndCrashResponse();

        response.setHeader(HeaderBean.createSuccess());
        Data bodyData = new Data(1, 0, Collections.emptyList());
        response.setBody(new Body(bodyData));

        return response;

    }

}
