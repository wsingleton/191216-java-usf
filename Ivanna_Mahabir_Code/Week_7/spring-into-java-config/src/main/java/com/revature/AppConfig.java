package com.revature;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan //by default Spring scans the package that THIS class is located within
@PropertySource("classpath:app.properties")
public class AppConfig {

/*    @Bean               // singleton beans are eagerly instantiated
    @Scope("prototype") //prototype beans are lazy instantiated. will create when called
    public Coach myCoach(){
        return new BaseballCoach(myMotivationService()); //constructor injection
    }

    @Bean
    public MotivationService myMotivationService(){
        return new MotivationService();
    }

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public FootballCoach myFootballCoach(){
        FootballCoach footballCoach = new FootballCoach();
        footballCoach.setMotivationService(myMotivationService());
        return footballCoach;
    }*/

}
