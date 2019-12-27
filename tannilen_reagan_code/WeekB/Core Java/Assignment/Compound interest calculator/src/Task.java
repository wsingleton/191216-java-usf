import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Task {

    public double calculateInterest(double principal, double time, double rate, double freq) {
        if (principal<0 || time<0 || rate<0 || freq<0) {
            return 0.0;
        }
        double roi;
        roi=(principal*Math.pow((1+(rate/freq)),(freq*time)));
        roi=Math.round(roi*100);
        roi=roi/100;
        return roi;
    }
}