package offer;

import org.junit.Test;

// 二叉树的下一个节点(中序遍历)
public class NextNodeOfBinaryTree {


    // 如果有右子树，返回右子树的最左节点
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null){
            return null;
        }

        // 右子树不为空
        if(pNode.right != null){

            TreeLinkNode node = pNode.right;
            while (node.left != null){
                node = node.left;
            }

            return node;

        }else {
            // 右子树为空, 递归的向上查找

            // 父节点
            TreeLinkNode node = pNode.next;

            while (node!=null && node.right == pNode){
                pNode = node;
                node = node.next;
            }

            return node;
        }

    }


    @Test
    public void test(){

    }
}


class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}