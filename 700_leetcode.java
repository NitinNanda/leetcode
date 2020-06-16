// 700. Search in a Binary Search Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        /*
        Return null is val is not found
         */
        if(root == null) return root;
        if(root.val == val) return root;
		/*
		if val is less than root.val then we need to search in the left subtree else right subtree
		 */
        else return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}