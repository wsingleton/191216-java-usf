package com.revature;

import com.revature.models.Coach;
import com.revature.models.FootballCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//If you later want this demo to be fully functioning you will have to copy the guts of the other classes from your Day1 demo

public class SpringDriver {

    public static void main(String[] args) {

        System.out.println("Creating the bean container...");

        try (AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class)) { //need to explicitly tell it the config class in use for the application

            System.out.println("Bean container created!");

            // Retrieve a coach from the container using the bean name

            Coach coach = container.getBean("myCoach", Coach.class);

            //Call some methods on the retrieved bean
            System.out.println(coach.getDailyWorkout());
            System.out.println(coach.getMotivation());


            System.out.println("'++++++++++++++++++++++++++++++++++++++");

            // attempt to get another coach from the container

            Coach assistantCoach = container.getBean("myCoach", Coach.class);
            System.out.println(coach);
            System.out.println(assistantCoach);

            System.out.println("++++++++++++++++++++++++++++++++++++++");

            FootballCoach footballCoach = container.getBean("footballCoach", FootballCoach.class);
            System.out.println();

            // get the newly created CodeCoach here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }
}
