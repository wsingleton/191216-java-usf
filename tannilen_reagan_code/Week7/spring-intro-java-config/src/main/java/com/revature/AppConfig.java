package com.revature;

import org.springframework.context.annotation.*;

@PropertySource("classpath:app.properties")
@Configuration
@ComponentScan
public class AppConfig {
}