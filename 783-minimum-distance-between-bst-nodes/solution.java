// 1 ms | 43.3 MB
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
    int min =Integer.MAX_VALUE;
    List<Integer> list =new LinkedList<>();
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        for(int i =1;i<list.size();i++){
            min =Math.min(min,(list.get(i)-list.get(i-1)));
        }
        return min;
        
    }

    public void inOrder(TreeNode root){
        if(root == null) return ;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}