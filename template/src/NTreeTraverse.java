public class NTreeTraverse {
    public void traverse(NTreeNode root) {
        for (NTreeNode child : root.children) {
            traverse(child);
        }
    }
}
