public class Task {

    public String[] fizzBuzz(int[] values) {

        if (values == null || values.length == 0) {
            return new String[0];
        }

        String[] fizzBuzzString = new String[values.length];

        for (int i = 0; i < values.length; i++) {

            if (values[i] % 3 == 0 && values[i] % 5 == 0) {
                fizzBuzzString[i] = "fizzbuzz";
            }
            else if (values[i] % 3 == 0) {
                fizzBuzzString[i] = "fizz";
            }
            else if (values[i] % 5 == 0) {
                fizzBuzzString[i] = "buzz";
            }
            else {
                String num = Integer.toString(values[i]);
                fizzBuzzString[i] = num;
            }
        }

        return fizzBuzzString;

    }

}