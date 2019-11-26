package hot100;


/**
 * User: yinkai
 * Date: 2019-11-25
 * Time: 21:45
 */
public class MaxPathSumOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(-7);

        root.left = node1;
        root.right = node2;

        node2.left = node3;
        node2.right = node4;

        MaxPathSumOfBinaryTree maxPathSumOfBinaryTree = new MaxPathSumOfBinaryTree();
        System.out.println(maxPathSumOfBinaryTree.maxPathSum(root));
    }

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }


    public int helper(TreeNode root) {

        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res = Math.max(left + right + root.val, res);
        return Math.max(0, Math.max(left, right) + root.val); // 返回的是最大值(如果返回0这一棵子树就放弃)
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
