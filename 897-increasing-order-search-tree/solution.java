// 0 ms | 43 MB

class Solution {
    List<Integer> list =new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        TreeNode dummy = new TreeNode(0);
        TreeNode curr =dummy;
        for(int n : list){
            curr.right=new TreeNode(n);
            curr =curr.right;
        }
        return dummy.right;

    }
    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}