package com.revature.util;

public class TreeNode {
    private Integer data;
    private TreeNode leftChild, rightChild;

    public TreeNode(Integer value){
        this.data = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
