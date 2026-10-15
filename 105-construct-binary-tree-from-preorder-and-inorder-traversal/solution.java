// 2 ms | 46.1 MB
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
    int preIdx =0;
    Map<Integer,Integer> pos =new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i =0;i<inorder.length;i++){
            pos.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length -1);
        
    }
    public TreeNode build(int[] preorder,int low,int high){
        if(low>high) return null;
        int rootVal =preorder[preIdx++];
        TreeNode node = new TreeNode(rootVal);
        int mid = pos.get(rootVal);
        node.left =build(preorder,low,mid-1);
        node.right =build(preorder,mid+1,high);
        return node;
    }
}