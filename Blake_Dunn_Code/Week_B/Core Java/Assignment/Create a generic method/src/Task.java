public class Task<T> {

    public void genericPrinter(T... string) {

        for (T str : string) {
            System.out.println(str);
        }
    }

}