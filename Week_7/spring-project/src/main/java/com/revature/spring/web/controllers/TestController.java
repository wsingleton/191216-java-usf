package com.revature.spring.web.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/test-controller")
public class TestController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/test", produces= MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String test() {
        return "Hello, Java-class configured Spring MVC!";
    }
}
