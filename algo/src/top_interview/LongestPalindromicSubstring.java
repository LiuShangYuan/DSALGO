package top_interview;

import org.junit.Test;

// 最长回文子串
public class LongestPalindromicSubstring {


    // babad     bab & aba
    public String longestPalindrome(String s) {
        if(s == null || "".equals(s)){
            return s;
        }
        int max_lens = 0;
        String ret = null;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int max = Math.max(len1, len2);
            if (max > max_lens) {
                max_lens = max;     // 10             9
                // 1 2 3 4 (5 6) 7 8 9 10  ---  1 2 3 4 (5) 6 7 8 9
                // max % 2 == 0? 以(i, i+1)为中心 : 以i为中心
                // start = i - (len -1)/2
                // end = i + (len / 2)
                ret = s.substring(i - (max - 1) / 2, i + max / 2 + 1);
            }
        }
        return ret;
    }


    // 以left和right为中心进行扩展
    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    @Test
    public void test(){
        System.out.println(longestPalindrome("babad"));
    }
}
