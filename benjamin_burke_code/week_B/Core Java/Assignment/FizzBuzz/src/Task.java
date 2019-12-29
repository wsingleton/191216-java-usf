public class Task {

    public String[] fizzBuzz(int[] values) {
        //didn't realize we could change the array
        //check for the array length is 0
        if (values == null || values.length==0){
            return new String[0];
        }

        //create a new array of strings to hold
        String[] newArr = new String[values.length];

        for(int i =1; i<values.length; i++){
            if ((i % 5==0) && (i %3==0))
                System.out.println("fizzbuzz");
            else if (i % 5==0)
                System.out.println("buzz");
            else if (i % 3==0)
                System.out.println("fizz");
            else
                System.out.println("Not divisible by 3 or 5.");
        }
        return newArr;

    }


}