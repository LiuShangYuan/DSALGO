package top_interview;

import org.junit.Test;

// 200. 岛屿数量
public class IslandsCount {
    public int numIslands(char[][] grid) {
        int row, column;
        try {
            row = grid.length;
            column = grid[0].length;
        }catch (Exception e){
            return 0;
        }


        int count = 0;

        for (int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                if (grid[i][j] == '1'){
                    count++;
                    dfs(i, j, row, column, grid);
                }
            }
        }
        return count;
    }


    public void dfs(int x, int y, int row, int column, char[][] grid){
        if(x < 0 || y < 0 || x >= row || y >= column){
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
        }else {
            return;
        }
        // 上
        dfs(x - 1, y, row, column, grid);
        // 下
        dfs(x + 1, y, row, column, grid);
        // 左
        dfs(x, y - 1, row, column, grid);
        // 右
        dfs(x, y + 1, row, column, grid);
    }


    @Test
    public void test(){
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));
    }
}
