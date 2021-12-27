package com.e.dxy.utils;

public class BinaryTree {
    public TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode find(int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (val < cur.val) {
                if (cur.left == null) {
                    return cur;
                }
                cur = cur.left;
            } else if (val > cur.val) {
                if (cur.right == null) {
                    return cur;
                }
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }


    public void put(int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            root = node;
        } else {
            TreeNode parent = find(val);
            if (val < parent.val) {
                parent.left = node;
                return;
            } else {
                parent.right = node;
                return;
            }
        }
        return;
    }
}
