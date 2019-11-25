package hot100;

import java.util.Stack;

/**
 * 32. 最长有效括号
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses(")("));
    }

    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int maxlens = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
                if (right > left) {
                    right = 0;
                    left = 0;
                }
            }

            if(left == right && left + right > maxlens){
                maxlens = left + right;
            }
        }

        left = 0;
        right = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
                if (left > right) {
                    right = 0;
                    left = 0;
                }
            } else {
                right++;
            }

            if(left == right && left + right > maxlens){
                maxlens = left + right;
            }
        }

        return maxlens;
    }

}
