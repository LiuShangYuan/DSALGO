package offeragain;
// 二叉搜索树的最近公共祖先
public class NearestAncestorOfBinarySearchTree {
    /***
     *
     * 从下往上
     * 1) 左子树是否包含p or q
     * 2) 右子树是否包含p or q
     * 3) 根节点是否为p or q
     *
     * 其中有两个满足的话, 当前根节点就是最近公共祖先
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

    // 返回true 和 false
    // 之后最下面第一个满足条件的节点能修改ans的值
    // 之后返回true, 其他节点满足不了这个条件
    public boolean help(TreeNode node, TreeNode p, TreeNode q){
        if (node == null){
            return false;
        }

        boolean left = help(node.left, p, q);
        boolean right = help(node.right, p, q);

        int sum = 0;
        if (left) sum++;
        if(right) sum++;

        if (node.val == p.val || node.val == q.val){
            sum++;
        }


        if (sum >= 2){
            ans = node;
            return true;
        }


        return sum > 0;
    }
}
