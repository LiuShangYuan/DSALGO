package hot100;

/**
 * User: yinkai
 * Date: 2019-11-26
 * Time: 21:53
 */

// 226. 翻转二叉树
public class InvertTree {
    public static void main(String[] args) {

    }


    public TreeNode invertTree(TreeNode root) {

        if(root == null){
            return root;
        }

        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);

        return root;
    }
}
