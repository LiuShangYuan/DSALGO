package offeragain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 从上到下打印二叉树
public class BinaryTreePrinterUp2Down {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();

        List<List<Integer>> list = new ArrayList<>();
        if (root == null){
            return list;
        }

        List<Integer> innerlist = new ArrayList<>();

        queue1.add(root);

        while (!queue1.isEmpty()){
            TreeNode node = queue1.pop();
            if(node != null){
                innerlist.add(node.val);
                if(node.left != null) {
                    queue2.addLast(node.left);
                }
                if (node.right != null) {
                    queue2.addLast(node.right);
                }
            }

            if (queue1.isEmpty()){
                list.add(innerlist);
                LinkedList<TreeNode> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
                queue2.clear();
                innerlist = new ArrayList<>();
            }
        }

        return list;

    }


    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);


        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        List<List<Integer>> l  = levelOrder(root);

        System.out.println();
    }
}
