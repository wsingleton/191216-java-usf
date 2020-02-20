package com.revature;

import com.revature.models.Coach;
import com.revature.models.FootballCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDriver {
    public static void main(String[] args) {
        System.out.println("Creating the bean container");

        try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("beans.xml")){

            System.out.println("Bean container created!");

            //retrieve a coach
            Coach coach = container.getBean("myCoach", Coach.class);

            System.out.println(coach.getDailyWorkout());
            System.out.println(coach.getMotivated());

            FootballCoach footballCoach = container.getBean("myFootballCoach", FootballCoach.class);
            System.out.println(footballCoach.getDailyWorkout());
            System.out.println(footballCoach.getMotivated());
            System.out.println(footballCoach.getTeam());
            System.out.println(footballCoach.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
