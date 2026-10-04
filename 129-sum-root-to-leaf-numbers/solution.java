// 0 ms | 42.8 MB
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
    public int sumNumbers(TreeNode root) {
        List<Integer> results =new LinkedList<>();
        dfs(root, 0, results);
        int total =0;
        for(int n : results){
            total+=n;
        }
        return total;
    }
    public void dfs(TreeNode root, int sum, List<Integer> results){
        if(root ==null) return ;
        if(root.left ==null && root.right ==null){
            results.add(sum*10+root.val);
            return;
        }
        dfs(root.left, sum*10+root.val, results);
        dfs(root.right, sum*10+root.val, results);
    }
}