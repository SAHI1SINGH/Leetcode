// 2 ms | 46.3 MB
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
 import java.util.*;
class Solution {
    int postIdx;
    Map<Integer,Integer> pos =new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx=postorder.length-1;
        for(int i =0;i<inorder.length;i++){
            pos.put(inorder[i],i);
        }
        return build(postorder,0,inorder.length-1);
    }
    public TreeNode build(int[] postorder, int low,int high){
        if(low>high) return null;
         
        int rootVal = postorder[postIdx--];
        TreeNode node =new TreeNode(rootVal);
        int mid =pos.get(rootVal);
        node.right=build(postorder,mid+1,high);
        node.left =build(postorder,low,mid-1);
        
        return node;
    }
}