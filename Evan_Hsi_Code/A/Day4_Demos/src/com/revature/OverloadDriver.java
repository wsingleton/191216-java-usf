package com.revature;

import com.revature.util.Overloader;

public class OverloadDriver {

    public static void main(String[] args) {

        Overloader overloader = new Overloader();
        overloader.method(1);
        overloader.method(1L);
        overloader.method();
        overloader.method(1,2,3);
        overloader.method(new Integer(1));

    }
}
