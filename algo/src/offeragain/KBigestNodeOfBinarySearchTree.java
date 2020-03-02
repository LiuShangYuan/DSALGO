package offeragain;

import java.util.Stack;

// 二叉搜索树的第k大节点
// 右子树 ----- 根 --------左子树 (逆序)
public class KBigestNodeOfBinarySearchTree {
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        int count = 0;

        while (node != null || !stack.isEmpty()){

            while (node != null){
                stack.push(node);
                node = node.right;
            }


            count++;
            node = stack.pop();
            if (count == k){
                return node.val;
            }

            node = node.left;
        }

        return -1;
    }

    // 二分查找
    public int kthLargest_V2(TreeNode root, int k) {


        int rn = help(root.right);
        if (rn + 1 == k){
            return root.val;
        }

        if (rn < k){
            // 右子树不够，从左子树查
            return kthLargest_V2(root.left, k - rn - 1);
        }else{
            return kthLargest_V2(root.right, k);
        }
    }


    // 子树的节点数
    public int help(TreeNode node){
        if (node == null){
            return 0;
        }

        int left = help(node.left);
        int right = help(node.right);

        return left + right + 1;
    }
}
