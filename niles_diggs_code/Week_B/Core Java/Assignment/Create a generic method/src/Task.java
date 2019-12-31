public class Task<Gen> {

    public void genericPrinter(Gen...arrayAlpha) {
        for (Gen types: arrayAlpha
             ) {
            System.out.println(types);
        }
    }

}