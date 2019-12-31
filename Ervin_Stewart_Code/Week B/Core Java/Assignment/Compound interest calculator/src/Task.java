import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import static java.lang.Math.pow;

public class Task {

    public double calculateInterest(double principal, double time, double rate, double freq) {

        if(principal <0 || time<0 || rate <0 || freq <0){ return 0;}
        double newvalue = 1;
        double power = time*freq;
         newvalue += rate/freq;
        double value;
        value= pow( newvalue, power);
        value *=principal;
        BigDecimal bd = new BigDecimal(value).setScale(2, RoundingMode.UP);
        double formatedValue = bd.doubleValue();
return formatedValue;
    }

}