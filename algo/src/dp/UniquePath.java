package dp;

/**
 * 62.不同路径
 */
public class UniquePath {
    public static void main(String[] args) {
        System.out.println(new UniquePath().uniquePaths(10, 10));
    }


    // 1)
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }


        return dp[m - 1][n - 1];
    }

    // 2) 出去起点和终点, 机器人总共会走m+n-2步, 向下走m-1, 向右走n-1  C(m+n-2, n-1)
    // 结果会溢出 XXX

    public int uniquePaths2(int m, int n) {
        int sumU = 1;
        int sumD = 1;
        int sumStep = m + n - 2;

        n = Math.min(m, n);

        for (int i = 0; i < n - 1; i++) {
            sumU *= (sumStep - i);
            sumD *= (i + 1);
        }


        return sumU / sumD;
    }

}
