package real2019;

import java.util.Scanner;

// 方格走法
public class FangGeZouFa {
    public static int help(int x, int y) {
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 0; i < y + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < x + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < x + 1; i++) {
            for (int j = 1; j < y + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[x][y];
    }


    // C(m+n, n);
    public static int help2(int x, int y) {
        int res = 1;
        for (int i = 1; i <= y; i++) {
            res = res * (x + i) / i;
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().trim().split(" ");
        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);
        System.out.println(help2(x, y));
    }
}
