package com.justbaum.webbff;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service1-service", url = "http://service1-service:8080")
public interface Service1Client {

    @GetMapping("/api/service1-data")
    String getService1Data();
}
