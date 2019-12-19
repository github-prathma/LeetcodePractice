import java.util.*;

import jdk.nashorn.api.tree.Tree;

import java.io.*;

class DiameterBT {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        if (l > r) {
            return 1+l;
        } else {
            return 1+r;
        }
    }

    public static int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        } 
        int lHeight = depth(root.left);
        int rHeight = depth(root.right);
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);
        return Math.max(lHeight+rHeight, Math.max(ldiameter, rdiameter));
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int ans = diameter(root);
        System.out.println(ans);

    }
}