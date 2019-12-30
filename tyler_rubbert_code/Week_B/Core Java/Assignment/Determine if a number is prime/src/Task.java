public class Task {

    public boolean isPrime(int value) {

        if (value <= 1) {
            return false;
        }
        else {
            int temp = value/2;
            for (int i = 2; i < temp; i++){
                if (value % i == 0) {
                    return false;
                }
            }
            return true;
        }

    }
}