public class Task {

    public String[] fizzBuzz(int[] values) {

        if (values == null || values.length == 0) {
            return new String[0];
        }

        String[] strArray = new String[values.length];

        for (int i = 0; i < values.length; i++) {
            if (values[i] % 15 == 0)
            {
                strArray[i] = "fizzbuzz";
            }
            else if (values[i] % 5 == 0)
            {
                strArray[i] = "buzz";
            }
            else if (values[i] % 3 == 0) {
                strArray[i] = "fizz";
            }
            else {
                strArray[i] = String.valueOf(values[i]);
            }
        }

        return strArray;

    }

}