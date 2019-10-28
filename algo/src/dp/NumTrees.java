package dp;

/**
 * 96. 不同的二叉搜索树数量
 */
public class NumTrees {
    public static void main(String[] args) {
        System.out.println(new NumTrees().numTrees(3));
    }

    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                g[i] += g[j - 1] * g[i - j];
            }
        }
        return g[n];
    }
}
