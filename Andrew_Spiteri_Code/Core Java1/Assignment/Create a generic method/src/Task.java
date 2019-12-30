public class Task <T> {

    public void genericPrinter(T... type) {
        for (T value:
             type) {
            System.out.println(value);
        }
    }

}