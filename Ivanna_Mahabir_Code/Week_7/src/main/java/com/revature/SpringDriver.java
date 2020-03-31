package com.revature;

import com.revature.models.Coach;
import com.revature.models.FootballCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDriver {

    public static void main(String[] args) {
        System.out.println("creating the bean container");


        try(ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("beans.xml")){

            System.out.println("bean container created");

            Coach coach = container.getBean("myCoach", Coach.class);

            System.out.println(coach.getDailyWorkout());
            System.out.println(coach.getMotivation());


            System.out.println("------------------------");

            FootballCoach footballCoach = container.getBean("footballCoach", FootballCoach.class);
            System.out.println(footballCoach.getDailyWorkout());
            System.out.println(footballCoach.getMotivation());
            System.out.println(footballCoach.getEmail());
            System.out.println(footballCoach.getTeam());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
