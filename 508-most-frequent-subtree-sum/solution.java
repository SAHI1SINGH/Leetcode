// 5 ms | 47.2 MB
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
    Map<Integer, Integer> freq = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        sum(root);
        int max =0;
        for(int c : freq.values()) max =Math.max(max,c);
        List<Integer> list =new ArrayList<>();
        for(int key : freq.keySet()){
            if(freq.get(key)==max) list.add(key);
        }
        int[] result = new int[list.size()];
        for(int i =0;i<list.size();i++){ result[i]=list.get(i);}
        return result;
 
    }

    public int sum(TreeNode node) {
        if (node == null)
            return 0;
        int s = node.val + sum(node.left) + sum(node.right);
        freq.put(s, freq.getOrDefault(s, 0) + 1);
        return s;

    }
}