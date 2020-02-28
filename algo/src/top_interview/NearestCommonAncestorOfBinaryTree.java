package top_interview;

import sun.reflect.generics.tree.Tree;

public class NearestCommonAncestorOfBinaryTree {
    /**
     *
     * 中序遍历, 递归时左右子树分别返回有没有p或q节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */

    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        help(root, p, q);

        return ans;
    }


    public boolean help(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return (p == null) && (q == null);
        }

        int rl = help(root.left, p, q)?1:0;
        int rr = help(root.right, p, q)?1:0;

        int mid = (root == p || root == q)?1:0;


        if(rl + rr + mid >= 2){
            ans = root;
            return true;
        }
        return (rr + rl + mid) > 0;
    }
}
