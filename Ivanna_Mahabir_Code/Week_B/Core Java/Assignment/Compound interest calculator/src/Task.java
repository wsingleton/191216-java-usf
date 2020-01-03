import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import static java.lang.Math.pow;

public class Task {

    public double calculateInterest(double principal, double time, double rate, double freq) {

        if (principal < 0 || time < 0 || rate < 0 || freq < 0) return 0;
            double interest = principal * Math.pow(1 + (rate/freq), freq*time);
        BigDecimal bigDecimal = BigDecimal.valueOf(interest);
        return bigDecimal.setScale(2, RoundingMode.HALF_UP).doubleValue();

    }

}