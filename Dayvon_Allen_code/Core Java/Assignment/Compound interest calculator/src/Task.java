import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Task {

    public double calculateInterest(double principal, double time, double rate, double freq) {
        DecimalFormat df = new DecimalFormat("0.00");
        if(principal < 0 || time < 0 || rate < 0 || freq < 0){
            return 0.0;
        }

        Double answer = principal * Math.pow((1 + rate/freq),(freq*time));
        return Double.parseDouble(df.format(answer));

    }

}