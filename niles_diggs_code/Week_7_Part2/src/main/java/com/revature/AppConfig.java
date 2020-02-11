package com.revature;


import com.revature.models.BaseballCoach;
import com.revature.models.Coach;
import com.revature.models.FootballCoach;
import com.revature.services.MotivationService;
import org.springframework.context.annotation.*;

// this is going to be the configuration class
@Configuration
@ComponentScan // by default scans the package that this class is located with
@PropertySource("classpath:app.properties")
public class AppConfig {

    /*
    @Bean //you can change the names here, and give init methods
    @Scope("prototype") // these beans a lazily instantiated, a lot of their lifecycles are different for this type of bean
    public Coach myCoach() {
        return new BaseballCoach(myMotivationService()); //constructor injection
    }

    @Bean
    public MotivationService myMotivationService() {
        return MotivationService();
    }

    @Bean
    public FootballCoach myFootballCoach() { //setting up for setter injection

        FootballCoach footballCoach = new FootballCoach();
        footballCoach.set
    }

     */

}
