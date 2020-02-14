package offer;

// 判断二叉树是否是平衡二叉树
public class BalanceBinaryTree {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(deep(root.left) - deep(root.right)) <= 1) {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        } else {
            return false;
        }
    }


    // 求二叉树深度
    public int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(deep(root.left), deep(root.right));
    }


    // 后序遍历的解法
    public boolean IsBalanced_Solution_(TreeNode root) {
        Height height = new Height();

        return help(root, height);
    }


    public boolean help(TreeNode root, Height height){
        if(root == null){
            height.height = 0; // null节点高度为0
            return true;
        }


        Height left_height = new Height();
        Height right_height = new Height();
        boolean left = help(root.left, left_height);
        boolean right = help(root.right, right_height);

        // 左右子树都平衡
        if(left && right){
            // 计算当前节点高度
            height.height = Math.max(left_height.height, right_height.height) + 1;
            if (Math.abs(left_height.height - right_height.height) <= 1) {
                return true;
            }

        }
        return false;
    }



    static class Height{
        public int height;


        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }


        @Override
        public String toString() {
            return super.toString();
        }
    }

}
