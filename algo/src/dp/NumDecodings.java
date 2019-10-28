package dp;

/**
 * 解码方法(没AC 边界条件乱)
 */
public class NumDecodings {
    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("100"));
    }


    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];

        if (s.charAt(0) == '0') {
            dp[0] = 0;
        } else {
            dp[0] = 1;
        }
        if (s.length() == 1) {
            return dp[0];
        }
        if (s.charAt(1) == '0') {
            dp[1] = dp[0];
        }else if (Integer.parseInt(s.substring(0, 2)) <= 26) {
            dp[1] = 2;
        }else{
            dp[1] = dp[0];
        }

        // 前一个数为1或2, 当前数为1----6 可以考虑着两个为一个码的方案
        for (int i = 2; i < len; i++) {
            if (s.charAt(i) == '0') {
                dp[i] = dp[i - 1];
                continue;
            }
            if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }


        return dp[len - 1];
    }
}
