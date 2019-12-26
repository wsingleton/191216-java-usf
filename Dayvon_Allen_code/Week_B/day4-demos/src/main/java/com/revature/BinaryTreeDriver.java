package com.revature;

import com.revature.util.MyBinaryTree;
import com.revature.util.TreeNode;

public class BinaryTreeDriver {

    public static void main(String[] args) {
        MyBinaryTree node = new MyBinaryTree();
        node.add(12);
        node.add(30);
        node.add(21);
        node.add(31);
        node.add(29);
        node.add(48);
        node.add(100);
        node.add(230);
        node.add(1040);

        System.out.println("The tree contains the value 21: " + node.containsValue(21));
        System.out.println("The tree contains the value 17: " + node.containsValue(17));
        System.out.println("The tree contains the value 230: " + node.containsValue(230));
        System.out.println("The tree contains the value 230: " + node.containsValue(231));



    }
}
