package com.revature;

import com.revature.util.MyBinaryTree;

public class BinaryTreeDriver {

    public static void main(String[] args){
        MyBinaryTree myTree = new MyBinaryTree();

        myTree.add(6);
        myTree.add(4);
        myTree.add(5);
        myTree.add(3);
        myTree.add(7);
        myTree.add(13);
        myTree.add(9);
        myTree.add(12);
        myTree.add(10);

        System.out.println("The tree contains the value 6 :: " + myTree.containsValue(6));
        System.out.println("The tree contains the value 12 :: " + myTree.containsValue(12));
        System.out.println("The tree contains the value 17 :: " + myTree.containsValue(17));
    }
}
