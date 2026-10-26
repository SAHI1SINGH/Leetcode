// 1 ms | 46.2 MB
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
    List<TreeNode> result = new ArrayList<>();
    Set<Integer> deleteSet = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int val : to_delete){
            deleteSet.add(val);
        }
        dfs(root, true);
        return result;
    }
    public TreeNode dfs(TreeNode root , boolean isRoot){
        if(root == null) return null;

        boolean shouldDelete = deleteSet.contains(root.val);

        if(isRoot && !shouldDelete){
            result.add(root);
        }

        root.left = dfs(root.left, shouldDelete);
        root.right = dfs(root.right, shouldDelete);

        return shouldDelete ? null : root;
    }
}