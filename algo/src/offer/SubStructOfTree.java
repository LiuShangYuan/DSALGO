package offer;

// 树的子结构
// 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
public class SubStructOfTree {
    // 现在A中找到和B的根节点相等的节点，再判断以该节点为根节点的树是否包含B
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = help(root1, root2);
            }
            if (!result) {
                result = help(root1.left, root2);
            }
            if (!result) {
                result = help(root1.right, root2);
            }
        }
        return result;
    }


    public boolean help(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        // 如果B不为空但是A已经空了
        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        // 左右两边都满足
        return help(root1.left, root2.left) && help(root1.right, root2.right);
    }
}
