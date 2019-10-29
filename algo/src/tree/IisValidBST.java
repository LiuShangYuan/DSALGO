package tree;


import java.util.Map;

/**
 * 98. 验证二叉搜索树
 */
public class IisValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(20);

        root.left = node1;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;


        System.out.println(new IisValidBST().isValidBST(root));
    }


    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }


    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        // 节点值应该在lower和upper之间
        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        return helper(node.left, lower, val) && helper(node.right, val, upper);
    }

}
