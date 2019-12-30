package com.revature;

import javax.crypto.spec.PSource;
import java.util.Scanner;

public class Deposit{
    double initialBalance;
        public double depositMoney (String money) {
            initialBalance += Double.parseDouble(money);
            return initialBalance;
        }
}
