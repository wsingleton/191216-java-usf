package com.revature;

import com.revature.models.BaseballCoach;
import com.revature.models.Coach;
import com.revature.models.FootballCoach;
import com.revature.services.MotivationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@PropertySource("classpath:app.properties")
@Configuration
public class AppConfig {
    @Bean
    @Scope("prototype")
    public Coach coach() {
        return new BaseballCoach(motivation());
    }
    @Bean
    public MotivationService motivation() {
        return new MotivationService();
    }
    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public FootballCoach fbCoach() {
        FootballCoach fbCoach=new FootballCoach();
        fbCoach.setMotivationService(motivation());
        return fbCoach;
    }
}