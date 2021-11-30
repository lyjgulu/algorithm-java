public class lc0124 {
    private int res = Integer.MIN_VALUE;

    public int maxPathSun(TreeNode root) {
        maxSum(root);
        return res;
    }

    public int maxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = Math.max(0, maxSum(node.left));
        int rightSum = Math.max(0, maxSum(node.right));
        res = Math.max(res, leftSum + rightSum + node.val);
        return node.val + Math.max(leftSum, rightSum);
    }
}


