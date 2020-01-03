import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import org.w3c.dom.ls.LSOutput;

public class Task<T> {

    public void genericPrinter(T... a) {
        for (T b : a) {
            System.out.println(b);
        }

    }
}