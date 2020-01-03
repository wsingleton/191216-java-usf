public class Task {

    public String[] fizzBuzz(int[] values) {

        if (values == null || values.length == 0) {
            return new String[0];
        }
        String[] stringArr = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 15 == 0) stringArr[i] = "fizzbuzz";
            else if (values[i] % 5 == 0) stringArr[i] = "buzz";
            else if (values[i] % 3 == 0) stringArr[i] = "fizz";
            else stringArr[i] = String.valueOf(values[i]);
        }
        return stringArr;

    }

}