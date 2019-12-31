public class Task {

    public boolean isPrime(int value) {


        boolean isTrue = true;
        if(value <=1){isTrue =false;
            return isTrue;}

        int halt = value/2;
        for(int i=2; i <halt; i++)
        {if(value%i == 0){isTrue = false;
        }}



    return isTrue;}
}