// 4 ms | 47 MB
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
    List<Integer> list =new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        int i =0;
        int j = list.size()-1;
        while(i<j){
            int sum = list.get(i)+list.get(j);
            if(sum == k) return true;
            else if( sum <k) i++;
            else j--;
        }
        return false;
    }
    public void inOrder(TreeNode root){
        if(root == null) return ;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}