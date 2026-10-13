// 0 ms | 46.9 MB
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
    Integer prev = null;
    int count =0;
    int maxCount =0;
    List<Integer> mode = new ArrayList<>();
    public int[] findMode(TreeNode root) {
       inOrder(root);
       int[] result =new int[mode.size()];
       for(int i =0;i< mode.size();i++){
        result[i] =mode.get(i);
       }
       return result;
    }
    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(  prev !=null && prev == root.val) count ++;
        else
            count =1;
        if(count >maxCount){
            maxCount =count;
            mode.clear();
            mode.add(root.val);
        }
        else if(count == maxCount){
            mode.add(root.val);
        }
        prev =root.val;
        inOrder(root.right);
    }
}