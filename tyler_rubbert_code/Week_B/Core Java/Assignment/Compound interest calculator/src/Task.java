import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Task {

    public double calculateInterest(double principal, double time, double rate, double freq) {

        double ans = principal * (1 + rate / freq ) * ((freq * time) * (1 + rate / freq));


    }

}