package com.justbaum.webbff;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebBffController {

    private final UserClient userClient;

    public WebBffController(final UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/api/test")
    public String getTestData() {
        return "this is a second test";
    }

    @GetMapping("/api/user-data")
    public String getService1Data() {
        return userClient.getUserData();
    }
}
