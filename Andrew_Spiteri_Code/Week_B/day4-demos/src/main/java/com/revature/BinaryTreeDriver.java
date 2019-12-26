package com.revature;

import com.revature.util.MyBinaryTree;

public class BinaryTreeDriver {
    public static void main(String[] args) {
        MyBinaryTree myTree = new MyBinaryTree();
        myTree.add(1);
        myTree.add(2);
        myTree.add(3);
        myTree.add(4);
        myTree.add(5);
        myTree.add(6);
        myTree.add(7);
        myTree.add(8);

        System.out.println("The tree contains the value 8 :: "+ myTree.containsValue(8));
        System.out.println("The tree contains the value 9 :: "+ myTree.containsValue(9));
    }

}
