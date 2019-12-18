import java.util.Scanner;

class Factorial {

    int factorial(int number){
        int factorial = 1;
        for (int i = number; i > 1; i--){
            factorial *= i;
        }
        return factorial;
    };
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        Factorial obj = new Factorial();
        System.out.println("Please enter an integer: ");
        int number = input.nextInt();
        System.out.println("Factorial of " + number +
                            " is " + obj.factorial(number));
    };
};

