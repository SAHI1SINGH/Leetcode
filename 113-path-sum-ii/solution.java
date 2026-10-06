// 2 ms | 45.6 MB
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results =new LinkedList<>();
        dfs(root,targetSum, new ArrayList<>() ,results);
        return results;
       
    }
        public void dfs(TreeNode root, int remainig, List<Integer> paths, List<List<Integer>> results ){
            if(root ==null) return ;
            paths.add(root.val);
            if(root.left ==null && root.right ==null && remainig ==root.val){
                results.add(new ArrayList<>(paths));
            }
            dfs(root.left, remainig- root.val,paths,results);
            dfs(root.right, remainig- root.val,paths,results);
            paths.remove(paths.size()-1);


        }
}