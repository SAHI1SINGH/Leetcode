// 0 ms | 46.2 MB
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
    int Val =0;
    public int findTilt(TreeNode root) {
        sum(root);
        return Val;
    }
    public int sum(TreeNode root){
        if(root ==null) return 0;
        int left =sum(root.left);
        int right=sum(root.right);
        Val+=Math.abs(left-right);
        return root.val+left +right;
    }
}