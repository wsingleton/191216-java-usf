public class Task {

    public String[] fizzBuzz(int[] values) {
        if(values == null || values.length == 0) return new String[0];

        String[] bizzFuzz = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            if(values[i] % 3 == 0 && values[i] % 5 == 0) bizzFuzz[i] = "fizzbuzz";
            else if(values[i] % 3 == 0) bizzFuzz[i] = "fizz";
            else if(values[i] % 5 == 0) bizzFuzz[i] = "buzz";
            else bizzFuzz[i] = String.valueOf(values[i]);
        }
        return bizzFuzz;

    }

}