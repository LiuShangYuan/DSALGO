package dp;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 */
public class GenerateTrees {
    public static void main(String[] args) {
        new GenerateTrees().generateTrees(3);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new LinkedList<TreeNode>();
        }
        List<TreeNode> alllist = generate_trees(1, n);

        return alllist;
    }


    public List<TreeNode> generate_trees(int start, int end) {

        List<TreeNode> alllist = new LinkedList<>();
        if (end < start) { // 空树
            alllist.add(null);
            return alllist;
        }

        for (int root = start; root <= end; root++) {
            List<TreeNode> left = generate_trees(start, root - 1);
            List<TreeNode> right = generate_trees(root + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode rootNode = new TreeNode(root);
                    rootNode.left = l;
                    rootNode.right = r;

                    alllist.add(rootNode);
                }
            }

        }
        return alllist;
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