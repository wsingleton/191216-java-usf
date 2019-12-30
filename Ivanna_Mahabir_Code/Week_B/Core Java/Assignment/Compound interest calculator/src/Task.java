import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import static java.lang.Math.pow;

public class Task {

    public double calculateInterest(double principal, double time, double rate, double freq) {

        double base = 1+(rate/time);
        double power = freq*time;
        return principal*pow(base, power);

    }

}