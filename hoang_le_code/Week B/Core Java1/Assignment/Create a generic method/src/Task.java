public class Task<e> {

    public void genericPrinter(e... values) {
        for (e val: values) {
            System.out.println(val);
        }
    }

}