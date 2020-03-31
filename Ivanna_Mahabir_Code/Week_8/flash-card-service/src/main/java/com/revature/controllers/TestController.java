package com.revature.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tester")
public class TestController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String test(){
        return "/test works!";
    }
}
