public class Task<T> {

    public void genericPrinter(T...array) {

        for (T s : array
             ) {
            System.out.println(s);
        }

    }

}