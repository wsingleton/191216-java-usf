import java.lang.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.lang.Math.*;

public class Task {

    public double calculateInterest(double principal, double time, double rate, double freq) {

        if (principal < 0 || time < 0 || rate < 0 || freq < 0) return 0.00;
        BigDecimal P0 = BigDecimal.valueOf(principal * Math.pow(1 + rate / freq, freq * time));
        return P0.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    }

