package com.revature;

import com.revature.util.MyBinarytree;
import com.revature.util.TreeNode;

public class BinarytreeDriver {
    public static void main(String[] args){

        MyBinarytree myTree = new MyBinarytree();
        myTree.add(6);
        myTree.add(4);
        myTree.add(5);
        myTree.add(3);
        myTree.add(7);
        myTree.add(13);
        myTree.add(9);
        myTree.add(12);
        myTree.add(10);

        System.out.println("the tree contain the value 6 :: " + myTree.containsValue(6));
        System.out.println("the tree contain the value 12 :: " + myTree.containsValue(12));
        System.out.println("the tree contain the value 17 :: " + myTree.containsValue(17));





    }
}
