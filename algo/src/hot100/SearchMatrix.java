package hot100;

/**
 * 240 搜索二维矩阵 II
 */
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };


        System.out.println(new SearchMatrix().searchMatrix(matrix, 35));
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows==0){
            return false;
        }
        int columns = matrix[0].length;

        return help(matrix, target, 0, columns - 1);
    }


    public boolean help(int[][] matrix, int target, int x, int y) {
        if (x >= matrix.length || y < 0) {
            return false;
        }

        if (matrix[x][y] == target) {
            return true;
        }

        if (matrix[x][y] > target) {
            return help(matrix, target, x, y - 1);
        } else {
            return help(matrix, target, x + 1, y);
        }

    }

}
