package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139 单词拆分
 * 1) 暴力
 * 2) 记忆化搜索
 * 3) dp
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "applepenapple";
        List list = Arrays.asList("apple", "pen");
        System.out.println(new WordBreak().wordBreak(s, list));
    }

    /* 超时
    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start) {
        if (start == s.length()) { // 开始匹配的位置等于串的末尾, 说明匹配过程结束
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }*/


//    public boolean wordBreak(String s, List<String> wordDict) {
//        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
//    }
//    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
//        if (start == s.length()) {
//            return true;
//        }
//        if (memo[start] != null) {
//            return memo[start];
//        }
//        for (int end = start + 1; end <= s.length(); end++) {
//            //找到一个匹配的单词, 并且后面的也可以拆分
//            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
//                return memo[start] = true;
//            }
//        }
//        return memo[start] = false;
//    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        Set<String> wset = new HashSet<>(wordDict);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                if (i > 0 && dp[i] == 0) {
                    break;
                }
                if (wset.contains(s.substring(i, j)) && dp[i] == 1) {
                    dp[j] = 1;
                }
            }
        }

        if (dp[s.length()] == 1) {
            return true;
        }
        return false;
    }
}
