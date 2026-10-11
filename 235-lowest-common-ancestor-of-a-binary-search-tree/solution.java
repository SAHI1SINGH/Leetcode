// 6 ms | 47.7 MB
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if(p.val<node.val && q.val<node.val) return lowestCommonAncestor(node.left,p,q);
        if(p.val>node.val && q.val>node.val) return lowestCommonAncestor(node.right,p,q);

        return node;
    }
}