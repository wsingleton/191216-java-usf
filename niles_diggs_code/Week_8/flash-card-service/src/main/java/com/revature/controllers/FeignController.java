package com.revature.controllers;


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

    @GetMapping(value = "/intercom1", produces = MediaType.TEXT_PLAIN_VALUE)
    public String intercom1() {
        return userClient.test();
    }

    @GetMapping(value = "/intercom1", produces = MediaType.TEXT_PLAIN_VALUE)
    public String intercom2() {
        return userClient.getColorHex();
    }

}
