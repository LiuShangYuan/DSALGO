package hot100;

/**
 * 最大正方形
 */
public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }


    /**
     *
     * dp[i][j]表示以i,j位置为右下角的正方形, 如果matrix[i][j] 为0, dp[i][j]也肯定为0, 因此不处理
     * 只处理为1的位置,
     * 多加1, 处理第一行和第一列的情况, 不用为maxlen考虑特殊情况
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {

        if(matrix == null || matrix.length==0){
            return 0;
        }
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

        int maxlen = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;

                    maxlen = Math.max(maxlen, dp[i][j]);
                }
            }
        }


        return maxlen * maxlen;
    }

}
