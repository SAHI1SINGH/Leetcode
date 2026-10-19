// 20 ms | 44.8 MB
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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return countFrom(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }
    public int countFrom(TreeNode node, long remaining){
        if(node == null) return 0;
        int count =(node.val == remaining)?1:0;
        return count+countFrom(node.left,remaining-node.val)+countFrom(node.right,remaining-node.val);
    }
}