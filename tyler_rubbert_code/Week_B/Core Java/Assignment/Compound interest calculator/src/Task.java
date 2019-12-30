import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Task {

    public double calculateInterest(double principal, double time, double rate, double freq) {

        if (principal <= 0 || time <= 0 || rate <= 0 || freq <= 0) {
            return 0;
        }

        double ans = principal * (1 + rate / freq ) * ((freq * time) * (1 + rate / freq));
        return ans;

    }

}