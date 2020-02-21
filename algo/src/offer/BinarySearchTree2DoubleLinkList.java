package offer;

import org.junit.Test;

import java.util.Stack;

// 二叉搜索树转双向链表
public class BinarySearchTree2DoubleLinkList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return pRootOfTree;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = pRootOfTree;
        TreeNode head = null, pre = null;
        boolean first = true;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 取栈顶
            TreeNode top = stack.pop();
            if (first) {
                head = top;
                pre = top;
                first = false;
            } else {
                pre.right = top;
                top.left = pre;
                pre = top;
            }

            root = top.right;
        }
        return head;
    }



    // {10,6,14,4,8,12,16}
    @Test
    public void test(){
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(14);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(12);
        TreeNode node6 = new TreeNode(16);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;


        Convert(root);

        System.out.println();
    }
}
