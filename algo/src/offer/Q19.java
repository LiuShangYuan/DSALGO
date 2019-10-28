package offer;

import java.util.Stack;

/**
 * 正则表达式匹配
 */
public class Q19 {
    public static void main(String[] args) {
        char[] str = {};
        char[] pattern = {'.', '*'};
//        System.out.println(new Q19().match(new String(pattern), new String(str), 0, 0));
        System.out.println(new Q19().match(".*", "", 0, 0));
    }


    public boolean match(char[] str, char[] pattern) {
        return match(new String(pattern), new String(str), 0, 0);
    }


    public boolean match(String pattern, String string, int pptr, int sptr) {

        // 两个串都用完了
        if (pptr == pattern.length() && sptr == string.length()) {
            return true;
        }

        // 模式串已经用完, 原串还有
        if (pptr == pattern.length() && sptr < string.length()) {
            return false;
        }


        if (pptr + 1 < pattern.length() && pattern.charAt(pptr + 1) == '*') {
            if (sptr < string.length() && pattern.charAt(pptr) == string.charAt(sptr) || (pattern.charAt(pptr) == '.' && sptr < string.length())) {
                return match(pattern, string, pptr + 2, sptr)
                        || match(pattern, string, pptr + 2, sptr + 1)
                        || match(pattern, string, pptr, sptr + 1);
            } else {
                return match(pattern, string, pptr + 2, sptr);
            }
        }

        // 后面不是 * 或者根本没有后面
        if (sptr < string.length() && pattern.charAt(pptr) == string.charAt(sptr) || (pattern.charAt(pptr) == '.' && sptr < string.length())) {
            return match(pattern, string, pptr + 1, sptr + 1);
        } else {
            return false;
        }
    }
}
