package com.revature;

import com.revature.util.MyBinaryTree;

public class BinaryTreeDriver {
    public static void main(String... args){
        MyBinaryTree myTree = new MyBinaryTree();
        myTree.add(6);
        myTree.add(4);
        myTree.add(12);
        myTree.add(45);
        myTree.add(7);
        myTree.add(8);
        myTree.add(15);
        myTree.add(18);
        myTree.add(9);
        myTree.add(3);

        System.out.println("The tree contains the value 6 :: " + myTree.containsValue(6));
        System.out.println("The tree contains the value 9 :: " + myTree.containsValue(9));
        System.out.println("The tree contains the value 17 :: " + myTree.containsValue(17));
    }
}
