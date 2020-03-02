package offeragain;

import sun.reflect.generics.tree.Tree;

// 判断二叉树是否平衡
public class ISBalancedBinaryTree {

    /***
     *
     * 后序遍历
     * // 左子树高度
     * // 右子树高度
     * // 根节点高度
     *
     *
     *
     * @param root
     * @return
     */

    public boolean isBalanced(TreeNode root) {
        Height h = new Height();
        return help(root, h);
    }


    public boolean help(TreeNode node, Height h){

        if (node == null){
            h.height = 0;
            return true;
        }

        Height lh = new Height();
        Height rh = new Height();

        boolean rl = help(node.left, lh);
        boolean rr = help(node.right, rh);

        h.height = Math.max(lh.height, rh.height) + 1;

        if (rl && rr && Math.abs(lh.height - rh.height) <=1){
            return true;
        }else{
            return false;
        }
    }

    static class Height{
        int height;
    }
}
