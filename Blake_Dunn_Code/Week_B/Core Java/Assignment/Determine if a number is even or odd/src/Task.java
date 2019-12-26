public class Task {

    public String isEvenOrOdd(int value) {

        String even = "even";
        String odd = "odd";

        if (value % 2 == 0){
            return even;
        }
        return odd;
    }
}