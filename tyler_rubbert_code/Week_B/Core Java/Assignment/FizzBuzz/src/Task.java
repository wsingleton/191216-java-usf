public class Task {

    public String[] fizzBuzz(int[] values) {

        if (values == null || values.length == 0) {
            return new String[0];
        }

        String[] solution = new String[values.length];

        for (int i = 0; i < solution.length; i++) {
            if ((i + 1) % 3 == 0) {
                if ((i + 1) % 5 == 0) {
                    solution[i] = "fizzbuzz";
                } else {
                    solution[i] = "fizz";
                }
            }else if((i + 1) % 5 == 0){
                solution[i] = "buzz";
            } else {
                solution[i] = String.valueOf(values[i]);
            }
        }
        return solution;

    }

}