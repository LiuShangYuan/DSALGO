package hot100;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * User: yinkai
 * Date: 2019-12-26
 * Time: 20:25
 */
public class PalindromeSubString {



    @Test
    public void test(){
//        TestCase.assertEquals(3, new PalindromeSubString().countSubstrings("abc"));
        TestCase.assertEquals(6, new PalindromeSubString().countSubstrings("aaa"));
    }


    // 动态规划

    // dp[i][j] 表示i~j之间的子串是否为回文串
    public int countSubstrings(String s) {
        int res = 0;
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
