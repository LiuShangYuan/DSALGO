package offer;

import org.junit.Test;

// 对称的二叉树
public class SymmetricBinaryTree {
    boolean isSymmetrical(TreeNode pRoot) {
        return help(pRoot, pRoot);
    }


    boolean help(TreeNode pRootA, TreeNode pRootB) {
        if (pRootA != null && pRootB != null) {
            return (pRootA.val == pRootB.val) && help(pRootA.left, pRootB.right) && help(pRootA.right, pRootB.left);
        }else if(pRootA == null && pRootB == null){
            return true;
        }else {
            return false;
        }
    }


    @Test
    public void test() {

    }
}
