package hot100;

/**
 * User: yinkai
 * Date: 2019-11-26
 * Time: 21:46
 */

// 104. 二叉树的最大深度
public class MaxDepthBinaryTree {
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

        System.out.println(new MaxDepthBinaryTree().maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}