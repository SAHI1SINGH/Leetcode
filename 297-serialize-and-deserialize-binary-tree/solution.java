// 7 ms | 48.5 MB
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        write(root,sb);
        return sb.toString();
    }
    public void write(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null,");
             return;
        }
        sb.append(node.val).append(",");
        write(node.left, sb);
        write(node.right, sb);
    }
    int idx;
    String [] tokens;
    public TreeNode deserialize(String data) {
        tokens = data.split(",");
        idx =0;
        return read();
    }
    public TreeNode read(){
        String t = tokens[idx++];
        if(t.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(t));
        node.left =read();
        node.right =read();
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));