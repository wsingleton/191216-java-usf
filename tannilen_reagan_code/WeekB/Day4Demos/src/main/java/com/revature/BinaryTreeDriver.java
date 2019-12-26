package com.revature;

import com.revature.util.MyBinaryTree;

public class BinaryTreeDriver {
    public static void main(String[] args) {
        MyBinaryTree pine = new MyBinaryTree();
        pine.add(13);
        pine.add(12);
        pine.add(42);
        pine.add(763);
        pine.add(0);
        pine.add(45);
        pine.add(66);
        pine.add(7);

        System.out.println("Contains 763? " + pine.contains(763));
        System.out.println("Contains 8? " + pine.contains(8));
        System.out.println("Contains 66? " + pine.contains(66));
    }
}
