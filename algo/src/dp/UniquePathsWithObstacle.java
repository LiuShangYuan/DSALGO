package dp;

/**
 * 63 不同路径II
 * 带障碍物
 */
public class UniquePathsWithObstacle {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(new UniquePathsWithObstacle().uniquePathsWithObstacles(obstacleGrid));
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int count = 0;

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        if(obstacleGrid[0][0]==0) {
            dp[0][0] = 1;
        }else{
            dp[0][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            // 前一个位置可以到达 并且当前位置没有障碍物
            if (dp[i - 1][0] > 0 && obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = 0;
            }
        }


        for (int i = 1; i < dp[0].length; i++) {
            if (dp[0][i - 1] > 0 && obstacleGrid[0][i] == 0) {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(obstacleGrid[i][j] != 0){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
