// 0 ms | 44.2 MB
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
    int cameras =0;
    public int minCameraCover(TreeNode root) {
       if( dfs(root)==0) cameras++;
        return cameras;
    }
    public int dfs(TreeNode node){
        if(node == null) return 1;
        int l =dfs(node.left);
        int r = dfs(node.right);
        if(l==0 || r ==0){
            cameras++;
            return 2;
        }
        if(l==2 || r == 2){
            return 1;
        }
        return 0;
    }
}