public class Task {

    public String isEvenOrOdd(int value) {
        if (value==0){
            return "even";
        }
        int val = Math.abs(value);
        int rem;
        rem=val%2;
        if (rem==1) {
            return "odd";
        }
        return "even";
    }
}