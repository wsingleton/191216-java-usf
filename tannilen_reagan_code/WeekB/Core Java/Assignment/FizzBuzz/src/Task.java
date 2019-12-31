public class Task {

    public String[] fizzBuzz(int[] values) {

        if (values==null || values.length==0) {
            return new String[0];
        }
        String[] fizzbuzz=new String[values.length];
        for (int i=0; i<values.length; i++) {
            int x = values[i];
            if (x%3==0 && x%5==0) {
                fizzbuzz[i]="fizzbuzz";
            }
            else if (x%3==0) {
                fizzbuzz[i]="fizz";
            }
            else if (x%5==0) {
                fizzbuzz[i]="buzz";
            }
            else {
                fizzbuzz[i]=Integer.toString(values[i]);
            }
        }
        return fizzbuzz;
    }
}