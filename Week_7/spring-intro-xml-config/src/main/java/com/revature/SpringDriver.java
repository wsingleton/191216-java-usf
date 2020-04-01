package com.revature;

import com.revature.models.Coach;
import com.revature.models.FootballCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDriver {

    public static void main(String[] args) {

        System.out.println("Creating the bean container...");

        try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("beans.xml")) {

            System.out.println("Bean container created!");

            // Retrieve a coach from the container using its bean name
            Coach coach = container.getBean("myCoach", Coach.class);

            // Call some methods on the retrieved bean
            System.out.println(coach.getDailyWorkout());
            System.out.println(coach.getMotivation());


            //-------------------------------------------

            // Attempt to get another coach from the the container
            Coach assistantCoach = container.getBean("myCoach", Coach.class);
            System.out.println(coach);
            System.out.println(assistantCoach);
            System.out.println(coach == assistantCoach);

            //--------------------------------------------

            FootballCoach footballCoach = container.getBean("footballCoach", FootballCoach.class);
            System.out.println(footballCoach.getDailyWorkout());
            System.out.println(footballCoach.getMotivation());
            System.out.println(footballCoach.getTeam());
            System.out.println(footballCoach.getEmail());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
