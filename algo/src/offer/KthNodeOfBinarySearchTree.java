package offer;

import org.junit.Test;

import java.util.LinkedList;

public class KthNodeOfBinarySearchTree {

    // 二叉搜索树的第k个结点
    // {8,6,10,5,7,9,11},0
    // {8,6,10,5,7,9,11},2
    TreeNode KthNode(TreeNode pRoot, int k) {

        if(pRoot == null || k <= 0)
            return null;
        TreeNode current = pRoot;
        TreeNode kNode = null;
        int count = 0;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        //中序遍历二叉搜索树
        while(!stack.isEmpty() || current != null)
        {
            while(current!=null) // 当前节点中序遍历的所有左节点入栈
            {
                stack.push(current);
                current = current.left;
            }
            if(!stack.isEmpty())
            {
                current = stack.pop();
                count++;
                if(count == k)
                {
                    kNode = current;
                    break;
                }
                current = current.right;
            }
        }
        return kNode;
    }


    @Test
    public void test(){
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(11);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        TreeNode res = KthNode(root, 2);

        System.out.println(res.val);
    }
}
