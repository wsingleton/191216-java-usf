public class Task {

    public String[] fizzBuzz(int[] values) {
        //didn't realize we could change the array
        //check for the array length is 0
        if (values == null || values.length==0){
            return new String[0];
        }

        //create a new array of strings to hold
        String[] newArr = new String[values.length];

        for(int i =0; i<values.length; i++){
            if (values[i] % 15==0)
                newArr[i] ="fizzbuzz";
            else if (values[i] % 5==0)
                newArr[i] = "buzz";
            else if (values[i] %3 ==0)
                newArr[i]="fizz";
            else
                newArr[i]=String.valueOf(values[i]);
        }
        return newArr;

    }


}