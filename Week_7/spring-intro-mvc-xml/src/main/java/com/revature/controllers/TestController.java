package com.revature.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test-controller")
public class TestController {

	@RequestMapping(value="/test", method=RequestMethod.GET, produces=MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String test() {
		return "Hello, Spring MVC!";
	}
}
