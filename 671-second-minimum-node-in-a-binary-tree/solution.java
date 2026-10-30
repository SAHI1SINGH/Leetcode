// 0 ms | 41.9 MB
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
    long min1 = Long.MAX_VALUE;
    long min2 = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        return min2 == Long.MAX_VALUE?-1:(int)min2;
    }
    public void dfs(TreeNode node){
        if(node == null) return ;
        if(node.val < min1){
            min2 = min1;
            min1 = node.val;

        }else if ( node.val > min1 && node.val < min2){
            min2 =node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }
}