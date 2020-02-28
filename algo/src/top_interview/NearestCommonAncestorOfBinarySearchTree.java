package top_interview;
// 235 二叉搜索树的最近公共祖先
public class NearestCommonAncestorOfBinarySearchTree {
    /**
     *
     * 说明:
     *
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉搜索树中。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int vp = p.val;
        int vq = q.val;

        while (root != null){
            int vparent = root.val;

            if(vparent > vp && vparent > vq){
                root = root.left;
                continue;
            }

            if (vparent < vp && vparent < vq){
                root = root.right;
                continue;
            }

            return root;
        }

        return null;
    }
}