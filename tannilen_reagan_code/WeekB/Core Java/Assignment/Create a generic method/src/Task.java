import java.util.ArrayList;

public class Task {

    public void genericPrinter (Object... items) {
        for (Object item : items) {
            System.out.println(item);
        }
    }

}