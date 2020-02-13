import com.revature.models.Adventurer;
import com.revature.models.MonkAdventurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDriver {

    public static void main(String[] args) {

        System.out.println("Creating the bean container....");


        try(ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("beans.xml")){

            System.out.println("Bean Container created!");

            Adventurer adventurer = container.getBean("myAdventurer", Adventurer.class);



            System.out.println(adventurer.getMightyPower());
            System.out.println(adventurer.getMotivation());
            System.out.println("----------------------------------------------------------------------------");


            Adventurer adventurer1 = container.getBean("myAdventurer", Adventurer.class);
            System.out.println(adventurer1);
            System.out.println(adventurer== adventurer1);

            System.out.println("------------------------------------------------------------------------------");


            MonkAdventurer monkAdventurer = container.getBean("myMonkAdventurer", MonkAdventurer.class);
            System.out.println(monkAdventurer.getMightyPower());
            System.out.println(monkAdventurer.getMotivation());
            System.out.println(monkAdventurer.getName());
            System.out.println(monkAdventurer.getWeapon());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
