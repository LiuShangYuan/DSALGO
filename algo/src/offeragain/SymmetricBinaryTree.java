package offeragain;
// 对称二叉树
public class SymmetricBinaryTree {
    /***
     *
     * 把树复制一个对比着比较
     *
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return help(root, root);
    }


    public boolean help(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 != null && node2!= null){
            if (node1.val == node2.val){
                return help(node1.left, node2.right) && help(node1.right, node2.left);
            }else {
                return false;
            }
        }
        return false;
    }
}
