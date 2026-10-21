// 2 ms | 49.6 MB
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

    int maxLength = 0; // Stores the longest path found

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);          // Calculate paths using DFS
        return maxLength;   // Return the maximum length in edges
    }

    private int dfs(TreeNode node) {

        // Base case: If the node is null, return 0
        if (node == null) {
            return 0;
        }

        // Find the longest matching path in the left subtree
        int leftPath = dfs(node.left);

        // Find the longest matching path in the right subtree
        int rightPath = dfs(node.right);

        // If the left child has the same value, extend the path
        if (node.left != null && node.left.val == node.val) {
            leftPath = leftPath + 1;
        } else {
            leftPath = 0;
        }

        // If the right child has the same value, extend the path
        if (node.right != null && node.right.val == node.val) {
            rightPath = rightPath + 1;
        } else {
            rightPath = 0;
        }

        // Update the maximum path passing through this node
        maxLength = Math.max(maxLength, leftPath + rightPath);

        // Return the longest single-direction path to the parent
        return Math.max(leftPath, rightPath);
    }
}