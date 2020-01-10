import java.math.BigDecimal;
import java.math.RoundingMode;

public class Task {
    public double calculateInterest(double principal, double time, double rate, double freq) {
        if (principal < 0 || time < 0 || rate < 0 || freq < 0) return 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(principal * Math.pow(1 + (rate / freq), freq * time));
        return bigDecimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}