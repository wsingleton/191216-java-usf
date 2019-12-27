package com.revature;

import com.revature.util.MyBinaryTree;
import com.revature.util.MyLinkedList;

public class BinaryTreeDriver {
    public static void main(String[] args) {

        MyBinaryTree myTree = new MyBinaryTree();

        myTree.add(6);
        myTree.add(2);
        myTree.add(8);
        myTree.add(3);
        myTree.add(7);
        myTree.add(5);
        myTree.add(12);
        myTree.add(9);

        System.out.println("The tree contains the value :: " + myTree.containsValue(6));

    }
}
