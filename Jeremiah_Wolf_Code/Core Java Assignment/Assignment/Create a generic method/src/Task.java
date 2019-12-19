public class Task<T> {

    public void genericPrinter(T... values) {
        for (T val: values) {
            System.out.println(val);
        }
    }

}