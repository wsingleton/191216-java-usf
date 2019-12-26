public class Task {

    public boolean isPrime(int value) {

        return (value % 2 != 0 && value % 3 != 0 && value % 5 != 0) ? true : false;

    }
}