package hot100;

import java.util.Arrays;

/**
 * 494 目标和
 */
public class FindTargetSumWays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
//        int[] nums = {};
        System.out.println(new FindTargetSumWays().findTargetSumWays_dp(nums, 3));
    }

    public int findTargetSumWays(int[] nums, int S) {

        return help(nums, S, 0);
    }


    public int help(int[] nums, int S, int start) {
        if (start == nums.length) {
            if (S == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        return help(nums, S - nums[start], start + 1) + help(nums, S + nums[start], start + 1);

    }


    /**
     * 转化成0-1背包问题
     *
     * @param nums
     * @param S
     */
    public int findTargetSumWays_dp(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }


        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }


        int[] dp = new int[(sum + S) / 2 + 1];
        dp[0] = 1;


        for (int i = 0; i < nums.length; i++) {
            for (int j = (sum + S) / 2; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[(sum + S) / 2];

    }
}
