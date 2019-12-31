public class Task<T> {

    public void genericPrinter(T... string) {
        for(T s: string){
            System.out.println(s);
        }
    }

}