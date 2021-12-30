import java.util.ArrayList;

public class lc0099 {

    public void recoverTree(TreeNode root) {
        ArrayList<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int[] swapNums = findSwapNums(nums);
        recover(root, 2, swapNums[0], swapNums[1]);
    }

    public void inorder(TreeNode node, ArrayList<Integer> nums) {
        if (node == null) {
            return;
        }
        inorder(node.left, nums);
        nums.add(node.val);
        inorder(node.right, nums);
    }

    private int[] findSwapNums(ArrayList<Integer> nums) {
        int len = nums.size();
        int n1 = -1, n2 = -1;
        for (int i = 0; i < len - 1; i++) {
            if (nums.get(i + 1) < nums.get(i)) {
                n2 = i + 1;
                if (n1 == -1) {
                    n1 = i;
                } else {
                    break;
                }
            }
        }
        int x = nums.get(n1), y = nums.get(n2);
        return new int[]{x, y};
    }

    private void recover(TreeNode node, int num, int res1, int res2) {
        if (node != null) {
            if (node.val == res1 || node.val == res2) {
                node.val = node.val == res1 ? res2 : res1;
                if (--num == 0) {
                    return;
                }
            }
            recover(node.left, num, res1, res2);
            recover(node.right, num, res1, res2);
        }
    }

}
