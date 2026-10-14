// 2 ms | 47.3 MB
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
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return build (0,list.size()-1);
        
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public TreeNode build(int lo, int hi){
        if(lo>hi) return null;
        int mid =lo+(hi-lo)/2;
        TreeNode node =new TreeNode(list.get(mid));
        node.left =build(lo,mid-1);
        node.right =build(mid+1,hi);
        return node;
    }
}