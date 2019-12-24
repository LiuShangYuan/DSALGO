package top_interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: yinkai
 * Date: 2019-12-24
 * Time: 19:58
 */

// 212. 单词搜索 II

public class WordSearchII {

    @Test
    public void test() {

//        String[] words = {"oath", "pea", "eat", "rain"};
        String[] words = {"aaa"};

//        char[][] board =
//                {
//                        {'o', 'a', 'a', 'n'},
//                        {'e', 't', 'a', 'e'},
//                        {'i', 'h', 'k', 'r'},
//                        {'i', 'f', 'l', 'v'}
//                };

        char[][] board =
                {
                        {'a', 'a'},
                };

        System.out.println(findWords(board, words));

    }

    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();

        for (String w : words) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            OUT:
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    boolean flag = help(board, i, j, w, 0, visited);
                    if(flag) {
                        result.add(w);
                        break OUT;
                    }
                }
            }


        }
        return result;
    }

    public boolean help(char[][] board, int x, int y, String word, int start, boolean[][] visited) {
        if (start == word.length()){
            return true;
        }

        int rows = board.length;
        int columns = board[0].length;

        if (x < 0 || x >= rows || y < 0 || y >= columns) {
            return false;
        } else {

            if (visited[x][y]) {
                return false;
            }


            if (board[x][y] == word.charAt(start)) {

                visited[x][y] = true;

                boolean res = help(board, x + 1, y, word, start + 1, visited) || help(board, x - 1, y, word, start + 1, visited)
                        || help(board, x, y + 1, word, start + 1, visited) || help(board, x, y - 1, word, start + 1, visited);

                visited[x][y] = res;

                return res;
            } else {
                return false;
            }
        }

    }

}
