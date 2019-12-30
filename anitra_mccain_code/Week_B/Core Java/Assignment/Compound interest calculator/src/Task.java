import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Task {

    public double calculateInterest(double principal, double time, double rate, double freq) {

        double P = principal;
        double R = rate;
        double n = freq;
        double t = time;
        double amount = P * Math.pow(1 + (R / n), n * t);

        if(P < 0 || R < 0 || n < 0 || t < 0) {
            return 0;
        }
//

//        System.out.println("The Principal amount is: " +P);
//        System.out.println("The Rate is: " +R);
//        System.out.println("The Frequency is: "+n);
//        System.out.println("The time: "+t);

        BigDecimal monetaryValue = BigDecimal.valueOf(amount);
        return  monetaryValue.setScale(2, RoundingMode.HALF_UP).doubleValue();

    }

    public static void main(String[] args) {
        Task task1 = new Task();
        double result = task1.calculateInterest(2000, 5, 4.5, 10);
        System.out.println("ROI is $" +result);

    }

}