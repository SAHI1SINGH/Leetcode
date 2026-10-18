// 1 ms | 46 MB
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
    class Pair{
        int depth;
        TreeNode node;
        Pair(int depth, TreeNode node){
            this. depth = depth;
            this.node =node;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }
    public Pair dfs(TreeNode root){
        if(root == null) return new Pair(0,null);
        Pair l =dfs(root.left);
        Pair r =dfs(root.right);
        if(l.depth == r.depth) return new Pair(l.depth +1 ,root);
        if(l.depth > r.depth) return new Pair(l.depth+1,l.node);
        return new Pair(r.depth+1,r.node);
    }
}