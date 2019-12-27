package com.revature.util;

public class TreeNode {
    private Integer data;
    private TreeNode leftchild;
    private TreeNode rightchild;

    public TreeNode(Integer value){
        this.data = value;
        this.leftchild = null;
        this.rightchild = null;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public TreeNode getLeftchild() {
        return leftchild;
    }

    public void setLeftchild(TreeNode leftchild) {
        this.leftchild = leftchild;
    }

    public TreeNode getRightchild() {
        return rightchild;
    }

    public void setRightchild(TreeNode rightchild) {
        this.rightchild = rightchild;
    }
}
