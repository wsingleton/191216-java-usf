public class Task {

    public String[] fizzBuzz(int[] values) {

        if(values == null||values.length ==0){return new String[0];}
        String[] buzz =new String[values.length];
        for(int i =0; i<values.length; i++){
            if (values[i]%3 == 0 && values[i]%5 == 0) {
                buzz[i] = "fizzbuzz";
            }else if(values[i]%3==0){buzz[i]= "fizz";}
            else if(values[i]%5==0){buzz[i]= "buzz";}
            else{buzz[i] = Integer.toString(values[i]);}
        }
return buzz;
    }

}