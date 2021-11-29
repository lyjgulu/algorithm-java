public class lc0124 {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return res;
    }

    public int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPathSum(root.left));
        int right = Math.max(0, maxPathSum(root.right));
        res = Math.max(res, left + right + root.val);
        return root.val + Math.max(left, right);
    }
}


