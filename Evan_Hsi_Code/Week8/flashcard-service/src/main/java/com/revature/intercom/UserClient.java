package com.revature.intercom;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="user-service")
@RequestMapping("/test")
public interface UserClient {

    @GetMapping(produces= MediaType.TEXT_PLAIN_VALUE)
    public String test();

    @GetMapping(value="/colorHex", produces=MediaType.TEXT_PLAIN_VALUE)
    public String getColorHex();

}
