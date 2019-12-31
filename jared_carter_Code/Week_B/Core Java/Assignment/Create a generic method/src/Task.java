public class Task<T> {

    public void genericPrinter(T...a) {
        for(T c: a )
            System.out.println(c);
    }

}