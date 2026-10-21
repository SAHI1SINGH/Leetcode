// 3 ms | 49.3 MB
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

    int best =0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);          
        return best;
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int leftGain = (node.left !=null && node.left.val == node.val)?left+1:0;
        int rightGain = (node.right  !=null && node.right.val == node.val)?right+1:0;
        best = Math.max(best, leftGain+rightGain);
        return Math.max(leftGain, rightGain);
    }
}