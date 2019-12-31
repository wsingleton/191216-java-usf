public class Task<T> {

    public void genericPrinter(T... tempArray) {
        for (T element : tempArray) {
            System.out.println(element);
        }
    }
}
