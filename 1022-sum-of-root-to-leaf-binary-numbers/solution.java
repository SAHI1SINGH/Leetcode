// 0 ms | 43.9 MB
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
    public int sumRootToLeaf(TreeNode root) {
        List<Integer> nums =new LinkedList<>();
        dfs(root,0,nums);
        int total =0;
        for(int n :nums)
            total+=n;
        return total;
    }
    public void dfs(TreeNode node, int sum, List<Integer> nums){
        if(node == null) return ;
        
        if(node.left ==null && node.right ==null){
            nums.add(sum*2+node.val);
            return;
        }
        dfs(node.left, sum*2+node.val, nums);
        dfs(node.right, sum*2+node.val, nums);
    }
  
}