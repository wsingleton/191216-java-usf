public class Task<T> {

    public void genericPrinter(T...input) {
        for (T s : input){
            System.out.println(s);
        }
    }

}