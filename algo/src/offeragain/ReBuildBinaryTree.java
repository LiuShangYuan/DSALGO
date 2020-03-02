package offeragain;

import java.util.*;

// 重建二叉树
public class ReBuildBinaryTree {
    /**
     *
     * 前序和中序 ===> 重建二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0){
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return help(preorder, inorder, 0, 0, inorder.length-1, map);
    }

    // pp 下一个根节点
    // left ---- right 左子树或右子树在中序序列中的元素范围
    // 根据前序中得到根节点, 在中序中找到左右子树的元素，递归的构建
    // [1,2,3]
    // [2,3,1]
    public TreeNode help(int[] preorder, int[] inorder, int pp, int left, int right, Map<Integer, Integer> map){

        if (left > right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pp]);


        // 存到一个Map里面（加快索引的获取）
        int index = map.get(preorder[pp]);
        System.out.println(index);
        for (int i=0;i<inorder.length;i++){
            if (inorder[i] == preorder[pp]){
                index = i;
            }
        }

        // 重建左子树
        TreeNode lnode = help(preorder, inorder, pp + 1, left, index-1, map);
        // 重建右子树
        TreeNode rnode = help(preorder, inorder, pp + (index - left) + 1, index+1, right, map);

        root.left = lnode;
        root.right = rnode;

        return root;
    }


}
