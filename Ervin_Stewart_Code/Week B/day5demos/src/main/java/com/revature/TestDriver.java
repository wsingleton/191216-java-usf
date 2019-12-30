package com.revature;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class TestDriver {
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    public static void main(String... args){
   System.out.println("Enter a dollar amount:");
double newInput;
    Scanner newinput = new Scanner(System.in);
       newInput = newinput.nextDouble();
        double input = newInput;
        BigDecimal bd = new BigDecimal(input).setScale(2, RoundingMode.DOWN);
        double nextInput = bd.doubleValue();

//df2.format(newInput);
        System.out.println(nextInput);
}}


