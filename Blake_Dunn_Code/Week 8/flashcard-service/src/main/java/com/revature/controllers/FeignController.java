package com.revature.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.revature.intercom.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignController {
    private UserClient userClient;

    @Autowired
    public FeignController(UserClient client) {
        this.userClient = client;
    }

    @HystrixCommand(fallbackMethod = "fallback1")
    @GetMapping(value = "/intercom1", produces = MediaType.TEXT_PLAIN_VALUE)
    public String intercom1() {
        return userClient.test();
    }

    @HystrixCommand(fallbackMethod = "fallback2")
    @GetMapping(value = "/intercom2", produces = MediaType.TEXT_PLAIN_VALUE)
    public String intercom2() {
        return userClient.getColorHex();
    }

    public String fallback1() {
        return "Fallback method #1 was invoked!";
    }

    public String fallback2() {
        return "Fallback method #2 was invoked!";
    }
}
