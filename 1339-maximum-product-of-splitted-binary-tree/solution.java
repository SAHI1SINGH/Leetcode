// 15 ms | 64.6 MB
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
    List<Long> sums = new ArrayList<>();
    public int maxProduct(TreeNode root) {
        long total = dfs(root);
        long best =0;
        for(long s : sums){
            best=Math.max(best,s*(total-s));
        }
        return (int) (best % 1_000_000_007);
    }
    public long dfs(TreeNode root){
        if(root == null) return 0;
        long s = root.val + dfs(root.left)+dfs(root.right);
        sums.add(s);
        return s;
    }
}
