public class Task {

    public String isEvenOrOdd(int value) {
        String numCheck = "";
        if(value%2 == 0){
            numCheck = "even";
            return numCheck;
        } else {
            numCheck = "odd";
            return numCheck;
        }
    }
}