// 6 ms | 46.8 MB
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
    public String smallestFromLeaf(TreeNode root) {
        List<String> result=new LinkedList<>();
        dfs(root,"",result);
        String best=result.get(0);
        for(String c:result){
            if (c.compareTo(best) < 0) best = c; 
        }
        return best;
    }
    public void dfs(TreeNode root,String path,List<String>result){
        if(root==null) return;
        path =(char) ('a'+root.val)+path;
        if(root.left ==null && root.right==null){
            result.add(path);
        }
        dfs(root.left,(path),result);
        dfs(root.right,(path),result);
    }
}