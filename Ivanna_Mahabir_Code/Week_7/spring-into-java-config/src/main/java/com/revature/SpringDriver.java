package com.revature;


import com.revature.models.Coach;
import com.revature.models.CodeCoach;
import com.revature.models.FootballCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDriver {

    public static void main(String[] args) {
        System.out.println("creating the bean container");


        try(AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class)){

            System.out.println("bean container created");

            Coach coach = container.getBean("myCoach", Coach.class);

            System.out.println(coach.getDailyWorkout());
            System.out.println(coach.getMotivation());

            System.out.println("------------------------");
            Coach assistantCoach = container.getBean("myCoach", Coach.class);
            System.out.println(coach);
            System.out.println(assistantCoach);
            System.out.println(coach == assistantCoach);

            System.out.println("------------------------");

            FootballCoach footballCoach = container.getBean("footballCoach", FootballCoach.class);
            System.out.println(footballCoach.getDailyWorkout());
            System.out.println(footballCoach.getMotivation());
            System.out.println(footballCoach.getEmail());
            System.out.println(footballCoach.getTeam());

            //--------------------------------------------

            CodeCoach coder = container.getBean("codeCoach", CodeCoach.class);
            System.out.println(coder.getDailyWorkout());
            System.out.println(coder.getMotivation());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
