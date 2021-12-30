import java.util.LinkedList;
import java.util.Queue;

public class lc0111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        int dep = 1;
        while (!qu.isEmpty()) {
            int si = qu.size();
            for (int i = 0; i < si; i++) {
                TreeNode node = qu.poll();
                if (node.left == null && node.right == null) {
                    return dep;
                }
                if (node.left != null) {
                    qu.offer(node.left);
                }
                if (node.right != null) {
                    qu.offer(node.right);
                }
            }
            dep++;
        }
        return dep;
    }
}
