// 0 ms | 47.2 MB
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
    int length =0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return length;
    }
    public int height(TreeNode root){
        if(root ==null) return 0;
        int left =height(root.left);
        int right =height(root.right);
        length =Math.max(length,left+right);
        return 1+Math.max(left,right);
    }
}