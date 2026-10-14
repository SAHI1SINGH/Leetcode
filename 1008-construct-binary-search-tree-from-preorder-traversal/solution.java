// 0 ms | 42.9 MB
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
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder,0,preorder.length-1);
    }
    public TreeNode build(int[] pre, int low, int high){
        if(low>high) return null;
        TreeNode node =new TreeNode(pre[low]);
        int k = low +1;
        while(k<=high && pre[k]<pre[low]) k++;
        node.left =build(pre,low+1,k-1);
        node.right =build(pre,k,high);
        return node;
    }
}