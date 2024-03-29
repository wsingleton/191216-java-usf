package com.revature;

import com.revature.models.BaseballCoach;
import com.revature.models.Coach;
import com.revature.models.FootballCoach;
import com.revature.services.MotivationService;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan // by default Spring scans the package that THIS class is located within
@PropertySource("classpath:app.properties")
public class AppConfig {

//    @Bean
//    @Scope("prototype")
//    public Coach myCoach() {
//        return new BaseballCoach(myMotivationService());
//    }
//
//    @Bean
//    public MotivationService myMotivationService() {
//        return new MotivationService();
//    }
//
//    @Bean(initMethod="customInit", destroyMethod="customDestroy")
//    public FootballCoach myFootballCoach() {
//        FootballCoach footballCoach = new FootballCoach();
//        footballCoach.setMotivationService(myMotivationService());
//        return footballCoach;
//    }
}
