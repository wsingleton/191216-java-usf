public class Task <T> {

    public void genericPrinter(T... a) {
        for(T t:a) System.out.println(t);
    }

}