package hot100;

/**
 * User: yinkai
 * Date: 2019-11-26
 * Time: 21:36
 */

//617. 合并二叉树
public class MergeBinaryTree {
    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 != null && t2 != null){
            t1.val += t2.val;
        }else if (t1 == null){
            return t2;
        }else if(t2 == null){
            return t1;
        }



        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);

        t1.left = left;
        t1.right = right;

        return t1;
    }
}
