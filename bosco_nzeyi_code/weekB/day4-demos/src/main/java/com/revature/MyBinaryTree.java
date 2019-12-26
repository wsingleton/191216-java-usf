package com.revature;

public class MyBinaryTree {

    private TreeNode root;

    public void add(Integer value){
        this.root = addRecursively(this.root, value);
    }

    private TreeNode addRecursively(TreeNode currentNode, Integer value){
        return null;
        // if the node passed to this method is null, return a new node containing value

//        if(currentNode == null){
//
////            System.out.println("The current node is null. Creating a new node to add to tree");
//            return new TreeNode(value);
//        }
//    }

//    public boolean containsValue (Integer value){
//
//        }
    }
}
