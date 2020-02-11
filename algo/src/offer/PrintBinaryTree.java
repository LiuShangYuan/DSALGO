package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 按行打印二叉树
public class PrintBinaryTree {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        while (!queue.isEmpty()) {
            ArrayList<Integer> ilist = new ArrayList<>();
            int old_size = queue.size();
            for (int i = 0; i < old_size && !queue.isEmpty(); i++) {
                TreeNode node = queue.remove();
                if (node != null) {
                    ilist.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            if(ilist.size() > 0) {
                list.add(ilist);
            }
        }
        return list;
    }

    ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        //存放结果
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (pRoot == null) {
            return arrayLists;
        }
        //使用队列，先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        //存放每行的列表
        ArrayList<Integer> arrayList = new ArrayList<>();
        //记录本层打印了多少个
        int start = 0;
        //记录下层打几个
        int end = 1;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            //添加到本行的arrayList
            arrayList.add(temp.val);
            start++;
            //每打印一个节点，就把此节点的下一层的左右节点加入队列，并记录下一层要打印的个数
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            //判断本层打印是否完成
            if (start == end) {
                //此时的queue中存储的都是下一层的节点，则end即为queue大小
                end = queue.size();
                start = 0;
                //把arrayList添加到结果列表arrayLists中
                arrayLists.add(arrayList);
                //重置arrayList
                arrayList = new ArrayList<>();
            }
        }

        return arrayLists;
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;

        long start = System.currentTimeMillis();
        Print(root);
        long end = System.currentTimeMillis();

        System.out.println(end - start);

        start = System.currentTimeMillis();
        Print2(root);
        end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
