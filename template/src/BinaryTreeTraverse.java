public class BinaryTreeTraverse {
    public void traverse(TreeNode root) {
        //前序遍历
        traverse(root.left);
        //中序遍历
        traverse(root.right);
        //后序遍历
    }
}
