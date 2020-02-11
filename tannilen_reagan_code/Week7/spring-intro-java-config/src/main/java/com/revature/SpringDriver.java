package com.revature;

import com.revature.models.Coach;
import com.revature.models.CodeCoach;
import com.revature.models.FootballCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDriver {
    public static void main(String[] args) {
        System.out.println("Creating the bean container...");
        try (AnnotationConfigApplicationContext container=new AnnotationConfigApplicationContext(AppConfig.class)){
            System.out.println("Bean container created.");
            Coach coach=container.getBean("coach", Coach.class);
            System.out.println(coach.getDailyWorkout());
            System.out.println(coach.getMotivation());
            FootballCoach footballCoach=container.getBean("fbCoach", FootballCoach.class);
            System.out.println(footballCoach.getDailyWorkout());
            System.out.println(footballCoach.getMotivation());
            System.out.println(footballCoach.getEmail());
            System.out.println(footballCoach.getTeam());
            CodeCoach wezley=container.getBean("codeCoach", CodeCoach.class);
            System.out.println(wezley.getDailyWorkout());
            System.out.println(wezley.getMotivation());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
