package com.revature;

import com.revature.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableSwagger2
@SpringBootApplication
public class AppConfig {

    @Autowired
    private ImageService imageService;

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }



}
