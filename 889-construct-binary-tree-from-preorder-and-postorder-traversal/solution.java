// 2 ms | 44.8 MB
import java.util.*;

class Solution {

    int preIdx = 0;
    Map<Integer, Integer> pos = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        // Reset the index in case the same object is reused
        preIdx = 0;
        pos.clear();

        // Store each postorder value and its index
        for (int i = 0; i < postorder.length; i++) {
            pos.put(postorder[i], i);
        }

        // Pass the complete ranges of both arrays
        return build(preorder, postorder,
                     0, preorder.length - 1,
                     0, postorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] postorder,
                          int preLow, int preHigh,
                          int postLow, int postHigh) {

        // No nodes in this subtree
        if (preLow > preHigh) {
            return null;
        }

        // The first preorder element is the root
        TreeNode node = new TreeNode(preorder[preLow]);

        // If only one node exists, return it
        if (preLow == preHigh) {
            return node;
        }

        // The next preorder element is the left subtree's root
        int leftNode = preorder[preLow + 1];

        // Find the left subtree root in postorder
        int mid = pos.get(leftNode);

        // Calculate the number of nodes in the left subtree
        int leftSize = mid - postLow + 1;

        // Construct the left subtree
        node.left = build(preorder, postorder,
                          preLow + 1, preLow + leftSize,
                          postLow, mid);

        // Construct the right subtree
        node.right = build(preorder, postorder,
                           preLow + leftSize + 1, preHigh,
                           mid + 1, postHigh - 1);

        return node;
    }
}