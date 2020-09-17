package com.justbaum.webbff;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebBffController {

    private final Service1Client service1Client;

    public WebBffController(final Service1Client service1Client) {
        this.service1Client = service1Client;
    }

    @GetMapping("/api/test")
    public String getTestData() {
        return "this is a test";
    }

    @GetMapping("/api/service1")
    public String getService1Data() {
        return service1Client.getService1Data();
    }
}
