// 7 ms | 63 MB
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
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return best;
    }
    public int[] dfs(TreeNode node){
        if(node == null) return new int[]{-1,-1};
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int goLeft = l[1]+1;
        int goRight =r[0]+1;
        best = Math.max(best, Math.max(goLeft,goRight));
        return new int[]{goLeft,goRight};
    }
}