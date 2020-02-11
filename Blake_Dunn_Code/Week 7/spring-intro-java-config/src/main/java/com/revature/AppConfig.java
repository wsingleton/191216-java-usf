package com.revature;

import com.revature.models.BaseballCoach;
import com.revature.models.Coach;
import com.revature.models.FootballCoach;
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
    public Coach myCoach() {
        return new BaseballCoach(myMotivationService());
    }

    @Bean
    public MotivationService myMotivationService() {
        return new MotivationService();
    }

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public FootballCoach myFootballCoach() {
        FootballCoach footballCoach = new FootballCoach();
        footballCoach.setMotivationService(myMotivationService());
        return footballCoach;
    }
}
