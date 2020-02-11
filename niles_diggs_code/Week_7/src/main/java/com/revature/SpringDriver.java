package com.revature;

import com.revature.models.Coach;
import com.revature.models.FootballCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SpringDriver {

    public static void main(String[] args) {
        System.out.println("Creating the bean container...");

        try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext()) {

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

            FootballCoach footballCoach = container.getBean("myFootballCoach", FootballCoach.class);
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
