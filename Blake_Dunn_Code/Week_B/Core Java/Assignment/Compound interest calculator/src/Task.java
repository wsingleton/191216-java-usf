import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class Task {

    public double calculateInterest(double principal, double time, double rate, double freq) {



        if (principal < 0 || time < 0 || rate < 0 || freq < 0)
            return 0;

        BigDecimal bigDick = BigDecimal.valueOf(principal * Math.pow(1 + (rate / freq), freq * time));
        return bigDick.setScale(2, RoundingMode.HALF_UP).doubleValue();

    }

}