import java.util.HashMap;
import java.util.Map;

public class lc0105 {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preStare, int preEnd, int inStare, int inEnd) {
        if (preStare > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStare]);
        int inRoot = indexMap.get(root.val);
        int numLeft = inRoot - inStare;
        root.left = build(preorder, inorder, preStare + 1, preStare + numLeft, inStare, inRoot - 1);
        root.right = build(preorder, inorder, preStare + numLeft + 1, preEnd, inRoot + 1, inEnd);
        return root;
    }
}
