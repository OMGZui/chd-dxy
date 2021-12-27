package com.e.dxy.leetcode;

import com.e.dxy.utils.TreeNode;
import org.junit.jupiter.api.Test;

public class TreeTest {

    @Test
    public void binaryTree() {
        TreeNode root = new TreeNode(1);
        TreeNode B = new TreeNode(3);
        TreeNode C = new TreeNode(6);
        TreeNode D = new TreeNode(9);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(10);

        // 构建静态二叉树
        root.left = B;
        root.right = E;

        B.left = C;
        B.right = D;

        C.left = null;
        C.right = null;

        D.left = null;
        D.right = null;

        E.left = F;
        E.right = null;

        F.left = null;
        F.right = null;
        inOrder(root);
    }

    // 左 中 右
    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.printf("%s->", node.val);
        inOrder(node.right);
    }
}
