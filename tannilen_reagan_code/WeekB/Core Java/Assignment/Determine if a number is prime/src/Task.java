public class Task {

    public boolean isPrime(int value) {

        if (value<=1) {
            return false;
        }
        if (value==2) {
            return true;
        }
        for (int i = 2; i<value;i++) {
            if (value%i==0) {
                return false;
            }
        }
        return true;
    }
}