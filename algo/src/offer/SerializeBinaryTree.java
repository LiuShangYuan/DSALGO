package offer;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树序列化和反序列化
 *
 *        1
 *   2        3
 * 4  null  5   null
 *
 *  1 2 4 # # # 3 5 # # #
 */
public class SerializeBinaryTree {
    String Serialize(TreeNode root) {
        if(root == null)
            return "#!";
        else {
            String res =  root.val + "!" + Serialize(root.left) + Serialize(root.right);

            return res;
        }
    }

    TreeNode Deserialize(String str) {

        String [] strs = str.split("!");
        Queue<String> queue = new ArrayDeque<>();
        for(String c : strs){
            queue.add(c);
        }

        TreeNode root = null;

        root = dhelp(queue);

        return root;
    }
    // 1 2 4 # # # 3 5 # # #
    public TreeNode dhelp(Queue<String> queue){
        TreeNode root = null;
        if (!queue.isEmpty()){
            if(queue.peek().equals("#")){
                queue.poll();
                return null;
            }else {
                root = new TreeNode(Integer.parseInt(queue.peek()));
                queue.poll();
                root.left = dhelp(queue);
                root.right = dhelp(queue);
            }
        }
        return root;
    }


    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;

        System.out.println(Serialize(root));

        System.out.println(Deserialize(Serialize(root)));
    }


}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
