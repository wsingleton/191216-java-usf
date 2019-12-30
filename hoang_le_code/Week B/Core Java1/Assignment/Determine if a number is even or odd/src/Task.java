public class Task {

    public String isEvenOrOdd(int value) {
        Double a = new Double(value);
        if ((a%2) == 0){
            return "even";
        }
        else {
            return "odd";
        }

    }
}