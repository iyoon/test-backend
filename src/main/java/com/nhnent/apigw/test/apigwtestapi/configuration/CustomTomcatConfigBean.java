package com.nhnent.apigw.test.apigwtestapi.configuration;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class CustomTomcatConfigBean implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Override
    public void customize(TomcatServletWebServerFactory factory) {

        factory.addConnectorCustomizers(connector -> {
            AbstractHttp11Protocol protocol = (AbstractHttp11Protocol)connector.getProtocolHandler();

            // connector는 connection을 닫기 전에 지정한 시간(ms) 동안 다른 Http Request 를 위해 대기 한다.
            // 기본 값으로는 connectionTimeOut 설정을 쓰고, -1로 설정시 무제한
            // protocol.setKeepAliveTimeout(-1);

            // 정해진 리퀘스트 카운트 만큼 수행을 하고 connection을 끊음.
            // -1: keep-alive infinite
            // 1: disable
            // 1>: limit
            protocol.setKeepAliveTimeout(9000);
//            protocol.setMaxKeepAliveRequests(-1);

        });

    }
}


