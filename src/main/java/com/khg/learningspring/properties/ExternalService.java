package com.khg.learningspring.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExternalService {

    @Value("${external.service.url}")  // app.properties dosyasından url al
    private String url;

    public String returnServiceUrl() {
        return url;
    }
}
