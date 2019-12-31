public class Task {

    public boolean isPrime(int value) {



        if (value <= 1) return false;

        for (int i = 2; i <= value/2; i++) {
            if(value % i == 0) return false;
        }

        return true;

        /*
        boolean valid = false;
                //no number is divisible more than its half.
                for(int i = 2, i <= value/2; ++i)
        { if(value % i == 0)
        {
            valid = true;
            break;
        }
            if (!valid)
                System.out.println(value + "is prime.");
            else
            System.out.println(value + "is not prime");
        }

         */

    }
}