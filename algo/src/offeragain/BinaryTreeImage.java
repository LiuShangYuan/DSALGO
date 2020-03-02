package offeragain;
// 二叉树的镜像
public class BinaryTreeImage {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode left = null;
        TreeNode right = null;
        if (root.left != null){
            left = mirrorTree(root.left);
        }

        if (root.right != null){
            right = mirrorTree(root.right);
        }

        root.left = right;
        root.right = left;

        return root;
    }
}
