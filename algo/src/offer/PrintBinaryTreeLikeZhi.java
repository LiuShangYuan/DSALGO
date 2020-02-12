package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

// 之字形打印二叉树
public class PrintBinaryTreeLikeZhi {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if(pRoot == null){
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> tmpstack = new Stack<>();
        stack.push(pRoot);

        boolean direction = true; // left --> right
        while (!stack.isEmpty()){
            // 从顶到底遍历栈 加入list
            ArrayList<Integer> tmplist = new ArrayList<>();
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                tmplist.add(node.val);
                if(direction){
                    if(node.left != null) {
                        tmpstack.push(node.left);
                    }
                    if(node.right != null) {
                        tmpstack.push(node.right);
                    }
                }else{
                    if(node.right != null) {
                        tmpstack.push(node.right);
                    }
                    if(node.left != null) {
                        tmpstack.push(node.left);
                    }
                }
            }

            if(tmplist.size() > 0){
                list.add(tmplist);
            }

            stack = tmpstack;
            tmpstack = new Stack<>();

            direction = !direction;
        }
        return list;
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


        ArrayList<ArrayList<Integer>> list = Print(root);

        System.out.println(Print(root));
    }
}
