import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import static java.lang.Math.pow;
import static jdk.nashorn.internal.objects.NativeMath.round;

public class Task {

    public double calculateInterest(double principal, double time, double rate, double freq) {



        if (principal < 0 || time < 0 || rate < 0 || freq < 0)
            return 0;

        double value = 1;
        double power = time * freq;
        value += rate/freq;

        double val;
        val = pow(value, power);
        val *= principal;
        BigDecimal bigDick = new BigDecimal(val).setScale(2, RoundingMode.HALF_UP);

        double bigD = bigDick.doubleValue();
        return bigD;


    }

}