package top_interview;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * User: yinkai
 * Date: 2019-12-21
 * Time: 11:43
 */

//297. 二叉树的序列化与反序列化
public class BinaryTreeSerialize {

    private static TreeNode EMPTY_NODE = new TreeNode(0);

    @Test
    public void test() {
//        TreeNode root = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(5);
//
//        root.left = node1;
//        root.right = node2;
//
//        node2.left = node3;
//        node2.right = node4;

//        System.out.println(serialize(root));

        TreeNode tmp = deserialize(serialize(null));
        System.out.println();
    }

    // Encodes a top_interview.tree to a single string.
    public String serialize(TreeNode root) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();

        ArrayList<String> arrayList = new ArrayList<>();
        if (root != null)
            arrayDeque.add(root);
        else
            return arrayList.toString();

        while (!arrayDeque.isEmpty()) {
            TreeNode node = arrayDeque.getFirst();
            if (node == EMPTY_NODE) {
                arrayList.add("null");
            } else {
                arrayList.add(Integer.toString(node.val));
                if (node.left == null) {
                    arrayDeque.add(EMPTY_NODE);
                } else {
                    arrayDeque.add(node.left);
                }
                if (node.right == null) {
                    arrayDeque.add(EMPTY_NODE);
                } else {
                    arrayDeque.add(node.right);
                }
            }

            arrayDeque.removeFirst();


        }

        while (arrayList.get(arrayList.size() - 1) == "null") {
            arrayList.remove(arrayList.size() - 1);
        }
        return arrayList.toString();

    }

    // Decodes your encoded data to top_interview.tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if(data.equals("")){
            return null;
        }

        String[] datas = data.split(",");

        TreeNode root = null;
        ArrayDeque<TreeNode> parents = new ArrayDeque<>();

        if (datas[0] != "null") {
            root = new TreeNode(Integer.parseInt(datas[0].trim()));
            parents.add(root);
        }

        int i = 1;


        while (!parents.isEmpty()) {

            String left = "null";
            String right = "null";

            if(i < datas.length) {
                left = datas[i].trim();
            }
            if(i+1 < datas.length){
                right = datas[i + 1].trim();
            }


            if (!left.equals("null")) {
                TreeNode leftnode = new TreeNode(Integer.parseInt(left));
                parents.getFirst().left = leftnode;

                parents.add(leftnode);
            }


            if (!right.equals("null")) {
                TreeNode rightnode = new TreeNode(Integer.parseInt(right));
                parents.getFirst().right = rightnode;
                parents.add(rightnode);
            }

            i += 2;

            parents.removeFirst();
        }


        return root;
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