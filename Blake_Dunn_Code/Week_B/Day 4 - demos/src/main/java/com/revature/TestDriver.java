package com.revature;

import com.revature.util.Test;

public class TestDriver {

    public static void main(String[] args) {

        String phrase = "    The   quick brown fox  jumped over the lazy  dog    ";

        phrase = phrase.trim().replaceAll("\\s+", " ");

        System.out.println(phrase);

    }
}
