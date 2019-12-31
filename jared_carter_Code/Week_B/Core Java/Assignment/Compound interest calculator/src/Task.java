import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Task {

    public double calculateInterest(double principal, double time, double rate, double freq) {

        if (principal < 0 || time < 0 || rate < 0 || freq < 0)
            return 0;
        //Big decimal more precise. Translates a long unscaled value and an int scale into a BigDecimal

        BigDecimal bd = BigDecimal.valueOf(principal* Math.pow(1 + (rate / freq), freq * time));
       // setScale to 2 doesn't get more than 2 decimal places. using rounding mode to round up at half.
        return bd.setScale(2, RoundingMode.HALF_UP).doubleValue();



    }

}