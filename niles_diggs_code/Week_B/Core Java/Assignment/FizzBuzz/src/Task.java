public class Task {

    public String[] fizzBuzz(int[] values) {

        if (values == null) {
            return new String[0];
        }
        String[] fizzArray = new String[values.length];
        for (int i = 0; i < values.length; i++)
        {
            
            if(values[i] % 3 == 0 && values[i] % 5 == 0){
                fizzArray[i] = "fizzbuzz";

            }

            else if(values[i] % 3 == 0){
                fizzArray[i] = "fizz";
            }

            else if(values[i] % 5 == 0){
                fizzArray[i] = "buzz";
            }

            else {
                fizzArray[i] = Integer.toString(values[i]);
            }
        }
        
        return fizzArray;
    }
}