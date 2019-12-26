public class Task {

    public boolean isPrime(int value) {

        if (value <= 1) return false;

        for (int i = 2; i <= value/2; i++) {
            if (value % i == 0) {
                    return false;
                }
            }
        return true;


    }
}