package offeragain;
// 二位数组中的查找
public class QueryInTwoDiimensionArr {

    /**
     * 从右上角
     *
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int x = 0;
        int y = column - 1;
        while (x >= 0 && x < row && y >= 0 && y<column){
            if (matrix[x][y] == target){
                return true;
            }else if (matrix[x][y] > target){
                y -= 1;
            }else {
                x+=1;
            }
        }

        return false;
    }
}
