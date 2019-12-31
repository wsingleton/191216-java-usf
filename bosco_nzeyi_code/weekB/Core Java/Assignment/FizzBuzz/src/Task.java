public class Task {

    public String[] fizzBuzz(int[] values) {

        if(values == null || values.length == 0){
            return new String[0];
        }

        String [] dickShit = new String[values.length];

        // now let's make a for loop

        for(int i = 0; i<values.length; i++){
            if((values[i])%3 == 0 && values[i] % 5 == 0){
                dickShit[i] = "fizzbuzz";
            } else if(values[i] % 3 == 0){
                dickShit[i] = "fizz";
            }
            else if (values[i] %5 == 0){
                dickShit[i] = "buzz";
            }
            else {
                String str = Integer.toString(values[i]);
                dickShit[i] = str;
            }
        }
        return dickShit;

    }

}