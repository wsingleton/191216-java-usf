public class Task {

    public boolean isPrime(int value) {

        double x = (value - 1)%6;
        double y = (value + 1)%6;

        if((value%5) != 0 && x == 0 || (value%5) != 0 && y == 0){
            return true;
        }else if(value == 1 || value == 3 || value == 5 || value == -1|| value == -3 || value == -5){
            return true;
        }
        else{
            return false;
        }

    }
}