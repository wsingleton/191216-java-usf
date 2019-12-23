package com.bank.dao;

import java.io.*;


public class ReadFile {

    static String acctFile =
            "C:/Users/bdunn/OneDrive/Desktop/repos/191216-java-usf/Blake_Dunn_Code/Project -1/Users.txt";

    public static void checkLogIn(String un, String pw) {

        String line = null;
        boolean bool = false;

        try {

            FileReader fileReader = new FileReader(acctFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readline()) != null) {

            }
        }

    }

}
