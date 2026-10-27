// 0 ms | 42.3 MB
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
    public boolean isUnivalTree(TreeNode root) {
        return check(root, root.val);
    }
    public static boolean check(TreeNode node, int val){
        if(node == null) return true;
        if(node.val != val) return false;
        return check(node.right,val)&& check(node.left,val);
    }
}