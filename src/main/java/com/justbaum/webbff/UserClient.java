package com.justbaum.webbff;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-service", url = "http://user-service:8080")
public interface UserClient {

    @GetMapping("/api/user-data")
    String getUserData();
}
