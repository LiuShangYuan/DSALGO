package tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        root.right = node1;

        node1.left = node2;


        System.out.println(new InorderTraversal().inorderTraversal_loop(root));
    }


    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        List<Integer> left = null;
        List<Integer> right = null;
        if (root.left != null) {
            left = inorderTraversal(root.left);
        }

        if (root.right != null) {
            right = inorderTraversal(root.right);
        }

        if (left != null) {
            list.addAll(left);
        }

        list.add(root.val);

        if (right != null) {
            list.addAll(right);
        }

        return list;

    }


    // 循环

    /**
     * 模拟递归的压栈过程
     *
     * @param root
     * @return
     */

    public List<Integer> inorderTraversal_loop(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;

        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;

            }

            if(!stack.empty()){
                p = stack.peek();
                list.add(p.val);
                stack.pop();
                p = p.right;
            }
        }


        return list;
    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}