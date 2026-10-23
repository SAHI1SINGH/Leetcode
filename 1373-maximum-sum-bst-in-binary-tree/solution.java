// 10 ms | 63.2 MB
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
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return best;
    }
    public int[] dfs(TreeNode node){
        if(node == null) return new int[]{1,Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        int[] left = dfs(node.left);
        int[] right =dfs(node.right);
        if(left[0]==1 && right[0]==1 && left[2]<node.val && node.val < right[1]){
            int sum = left[3]+right[3]+node.val;
            best =Math.max(best,sum);
            return new int[]{1,Math.min(left[1],node.val),Math.max(right[2],node.val),sum};
        }
        return new int[]{0,0,0,0};
    }
}