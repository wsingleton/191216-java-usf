public class Task {

    public boolean isPrime(int value) {

        if( value <= 1){
            return false;
        }
        int num = value/2;
        for(int i = 2; i <= num; i++){
            if(value % i == 0){
                return false;
            }
        }
        return true;
    }
}