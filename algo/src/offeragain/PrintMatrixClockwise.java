package offeragain;
// 顺时针打印矩阵

import org.junit.Test;

/***
 *
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 *
 * 1 2 3 6 9 8 7 4 5
 *
 *
 *
 *
 */

public class PrintMatrixClockwise {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length==0 || matrix[0].length==0){
            return new int[]{};
        }
        int left = 0;
        int right = matrix[0].length-1;
        int up = 0;
        int down = matrix.length-1;

        int[] arr = new int[matrix.length * matrix[0].length];
        int index = 0;

        while (left<=right && up <= down){
            // left - right
            for (int i=left; i<=right;i++){
                arr[index++] = matrix[up][i];
            }

            // top - down
            for (int i=up+1;i<=down;i++){
                arr[index++] = matrix[i][right];
            }


            // 最后剩一横的情况，如果在从右向左则会重复
            if (up < down) {
                // right - left
                for (int i = right - 1; i >= left; i--) {
                    arr[index++] = matrix[down][i];
                }
            }


            // 最后剩一竖的情况, 如果在从下向上则会重复
            if (left < right) {
                // down - up

                for (int i = down - 1; i > up; i--) {
                    arr[index++] = matrix[i][left];
                }
            }

            left++;
            up++;

            right--;
            down--;

        }
        return arr;

    }

    @Test
    public void test(){

    }
}
