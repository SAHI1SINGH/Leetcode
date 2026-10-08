// 1 ms | 43 MB
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results =new ArrayList<>();
        if(root ==null) return results;
        Queue<TreeNode> q =new LinkedList<>();
        q.add(root);
        boolean leftToRight =true;
        while(! q.isEmpty()){
            int size =q.size();
            List<Integer> level =new LinkedList<>();
            for(int i =0;i<size;i++){
                TreeNode node =q.poll();
                level.add(node.val);
                if(node.left !=null) q.add(node.left);
                if(node.right !=null) q.add(node.right);
            }
            if(!leftToRight) Collections.reverse(level);
            results.add(level);
            leftToRight =!leftToRight;
        }
        return results;
    }
}