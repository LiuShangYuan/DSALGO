package top_interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// 54 螺旋矩阵
public class ScrewMatrix {
    /**
     *
     * 输入:
     * [
     *  [ 1, 2, 3, 4 ],
     *  [ 5, 6, 7, 8 ],
     *  [ 9, 10, 11, 12]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     *
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int row;
        int columns;

        try {
            row = matrix.length;
            columns = matrix[0].length;
        }catch (Exception e){
            return list;
        }


        int left = 0;
        int right = columns - 1;
        int up = 0;
        int down = row - 1;


        while (left <= right && up <= down){
            // left -> right
            for(int i=left;i<=right;i++){
                list.add(matrix[up][i]);
            }

            // up ---> down
            for (int i = up+1;i<=down;i++){
                list.add(matrix[i][right]);
            }

            // right -> left
            if(down > up) { // 最后剩一横
                for (int i = right - 1; i >= left; i--) {
                    list.add(matrix[down][i]);
                }
            }

            // down - up
            if(right > left) { // 最后剩一竖
                for (int i = down - 1; i >= up + 1; i--) {
                    list.add(matrix[i][left]);
                }
            }

            left++;
            up++;
            right--;
            down--;
        }
        return list;
    }


    @Test
    public void test(){
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(spiralOrder(matrix));
    }
}
