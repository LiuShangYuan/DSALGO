package top_interview;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * User: yinkai
 * Date: 2019-12-24
 * Time: 21:31
 */

//72. 编辑距离
public class EditDistance {


    @Test
    public void test() {
        TestCase.assertEquals(3, minDistance("horse", "ros"));
        TestCase.assertEquals(5, minDistance("intention", "execution"));
    }

    /**
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     *
     *
     * 动态规划就完事了
     *
     * @param word1
     * @param word2
     * @return
     */

    public int minDistance(String word1, String word2) {
        int[][] tmp = new int[word1.length() + 1][word2.length() + 1];


        for (int i = 0; i < tmp.length; i++) {
            tmp[i][0] = i;
        }

        for (int i = 0; i < tmp[0].length; i++) {
            tmp[0][i] = i;
        }


        for (int i = 1; i < tmp.length; i++) {
            for (int j = 1; j < tmp[0].length; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    tmp[i][j] = tmp[i-1][j-1];
                }else {
                    tmp[i][j] = Math.min(Math.min(tmp[i-1][j], tmp[i][j-1]), tmp[i-1][j-1]) + 1;
                }
            }
        }

        return tmp[word1.length()][word2.length()];
    }
}
