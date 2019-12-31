public class Task<T> {

    public void genericPrinter(T... string) {
        for(T strong: string)
            System.out.println(strong);
    }

}