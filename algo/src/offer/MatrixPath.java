package offer;

import org.junit.Test;

import java.util.Arrays;

// 矩阵中的路径
public class MatrixPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[] visited = new boolean[rows * cols];
                boolean res = help(matrix, i, j, str, 0, rows, cols, visited);
                if(res){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean help(char[] matrix, int i, int j, char[] strm, int index, int rows, int cols, boolean[] visited) {
        // 匹配完了
        if (index == strm.length) {
            return true;
        }


        // 超出边界
        if(i<0 || i >=rows || j<0 || j>=cols){
            return false;
        }

        // 该位置被访问了
        if (visited[i * cols + j]) {
            return false;
        }
        if (matrix[i * cols + j] == strm[index]) {
            visited[i * cols + j] = true;
            // 上下左右一次尝试
            boolean res = help(matrix, i,j+1, strm, index+1, rows, cols, visited)
                    || help(matrix, i, j-1, strm, index+1, rows, cols, visited)
                    || help(matrix, i+1, j, strm, index+1, rows, cols, visited)
                    || help(matrix, i-1,j,strm,index+1, rows, cols,visited);
            if(res){
                return true;
            }else {
                visited[i * cols + j] = false;
                return false;
            }
        } else {
            return false;
        }
    }


    @Test
    public void test(){
        char[] matrix= {'a', 'b', 'c', 'e', 's', 'f', 'c','s', 'a', 'd','e', 'e'};

        char[] str = {'c', 'c', 'f', 'd', 'e'};
//        char[] str = {'b', 'c', 'c', 'e', 'd'};


        System.out.println(hasPath(matrix, 3, 4, str));
    }
}
