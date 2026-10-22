// 0 ms | 43.4 MB
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
    int moves =0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
    public int dfs(TreeNode node){
        if(node == null) return 0;
        int l =dfs(node.left);
        int r = dfs(node.right);
        moves += Math.abs(l)+ Math.abs(r);
        return node.val+r+l-1;
    }
}