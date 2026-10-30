// 1 ms | 42.2 MB
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
    List<Integer> list = new ArrayList<>();
    public boolean checkTree(TreeNode root) {
        int sum=0;
        dfs(root, list);
        for(int num : list){
            sum+=num;
        }
        if(sum == root.val) return true;

        return false;
    }
    public void dfs(TreeNode node,List<Integer> list){
        if(node == null) return ;
        dfs(node.left,list);
        if(node.left == null && node.right == null){
            list.add(node.val);
            return;
        }
        dfs(node.right,list);
    }
}