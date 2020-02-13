package com.revature;

import com.revature.models.BaseballCoach;
import com.revature.models.Coach;
import com.revature.services.MotivationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;


@Configuration
@PropertySource("classpath:app.properties")
public class AppConfig {

    @Bean
    @Scope("prototype")
    public Coach myCoach(){
        return new BaseballCoach(new MotivationService());
    }
}