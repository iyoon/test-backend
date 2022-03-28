package com.nhnent.apigw.test.apigwtestapi.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class HeaderBean {

    private Boolean isSuccessful;
    private int resultCode;
    private String resultMessage;


    @JsonIgnore
    public boolean isNotSuccessful() {
        return isSuccessful == false;
    }


    public static HeaderBean createSuccess() {
        return new HeaderBean().setIsSuccessful(true)
                               .setResultCode(0)
                               .setResultMessage("SUCCESS");
    }
}
