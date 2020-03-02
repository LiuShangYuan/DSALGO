package offeragain;

// 二叉树的深度
public class BinaryTreeDepth {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int ld = maxDepth(root.left);
        int rd = maxDepth(root.right);

        return Math.max(ld, rd) + 1;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}