package com.nhnent.apigw.test.apigwtestapi.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainResponse {

    private HeaderBean header;


    public DomainResponse() {
        this.header = HeaderBean.createSuccess();
    }

    // ---


    public static DomainResponse createSuccess() {
        return new DomainResponse();
    }

}

