package top_interview;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * User: yinkai
 * Date: 2020-01-07
 * Time: 20:58
 */

// 230 二叉搜索树中第K小的元素
public class KthSmallestInBinaryTree {


    @Test
    public void test() {
//        TreeNode root = new TreeNode(3);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(2);
//
//        root.left = node1;
//        root.right = node2;
//        node1.right = node3;

//        TestCase.assertEquals(1, new KthSmallestInBinaryTree().kthSmallest(root, 1));


        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(1);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;


        TestCase.assertEquals(3, new KthSmallestInBinaryTree().kthSmallest(root, 3));
    }


    public int kthSmallest(TreeNode root, int k) {
        return help(root, new Body(k));
    }


    public Integer help(TreeNode root, Body body) {
        if (root == null) {
            return null;
        }

        Integer res = null;

        if (root.left != null) {
            res = help(root.left, body);
        }
        if (res == null) {
            if (body.val == 1) {
                res = root.val;
            }
            body.val--;
        }

        if (res == null && root.right != null) {
            res = help(root.right, body);
        }

        return res;
    }


    static class Body{
        int val;

        public Body(int val){
            this.val = val;
        }
    }
}
