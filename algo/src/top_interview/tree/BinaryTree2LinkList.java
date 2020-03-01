package top_interview.tree;

import org.junit.Test;

import java.util.Stack;

public class BinaryTree2LinkList {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode pre = null;
        boolean first = true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode top = root;

        while (!stack.isEmpty()){
            top = stack.pop();
            if (first){
                pre = top;
                first = false;
            }else {
                pre.right = top;
                pre.left = null;
                pre = top; // update pre
            }

            if(top.right != null) {
                stack.push(top.right);
            }
            if(top.left != null) {
                stack.push(top.left);
            }
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.right = node5;


        flatten(root);

        System.out.println();
    }

}
