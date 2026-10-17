// 1 ms | 45.9 MB
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
    int i =0;
    String s ;
    public TreeNode recoverFromPreorder(String traversal) {
        s= traversal;
        return build(0);
    }
    public TreeNode build(int depth){
        int j =i;
        while(j<s.length() && s.charAt(j)=='-') j++;
        int dashes = j-i;
        if(dashes !=depth) return null;
        i=j;
        int val =0;
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            val = val*10+(s.charAt(i)-'0');
            i++;
        }
        TreeNode node = new TreeNode(val);
        node.left =build(depth+1);
        node.right =build(depth+1);

        return node;

    }
}