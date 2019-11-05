package hot100;

/**
 * 79 单词搜索
 * 回溯
 *
 * 因为要一个辅助空间记录每个位置是否的访问过, 因此要注意在回溯的时候将对应之间访问的位置变成未访问状态
 *
 */
public class WordSearch {
    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };


        System.out.println(new WordSearch().exist(board, "SEE"));
    }

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean sret = help(board, visited, word, i, j, 0);
                if(sret){
                    return true;
                }
            }
        }


        return false;
    }


    public boolean help(char[][] board, boolean[][] visited, String word, int i, int j, int index) {

        // 串已经匹配完了
        if (word.length() == index) {
            return true;
        }

        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
            return false;
        }

        // i,j位置应经访问过了
        if (visited[i][j]) {
            return false;
        }

        if (board[i][j] == word.charAt(index)) {
            visited[i][j] = true;
            boolean ret = help(board, visited, word, i - 1, j, index + 1)
                    || help(board, visited, word, i + 1, j, index + 1)
                    || help(board, visited, word, i, j - 1, index + 1)
                    || help(board, visited, word, i, j + 1, index + 1);

            if (ret) {
                return true;
            } else { // 回溯
                visited[i][j] = false;
            }
        }

        return false;
    }
}
