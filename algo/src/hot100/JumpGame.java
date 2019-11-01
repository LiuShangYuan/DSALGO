package hot100;

import java.util.Arrays;

/**
 * 55. 跳跃游戏
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {3, 2, 1, 0, 4};
//        int[] nums = {2, 0, 0};
//        int[] nums = {1, 2, 3};
        System.out.println(new JumpGame().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        return help3(nums);
    }

    // 回溯, 超时
    public boolean help(int[] nums, int start) {
        if (start == nums.length - 1) {
            return true;
        }
        for (int j = 1; j <= nums[start]; j++) {
            if (help(nums, start + j))
                return true;
        }


        return false;
    }


    // 动态规划
    // 虽然能通过但是时间复杂度有点高
    public boolean help2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        boolean[] dp = new boolean[nums.length];

        Arrays.fill(dp, false);
        dp[nums.length - 1] = true;


        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 0; j <= nums[i] && (i + j) < nums.length; j++) {
                if (dp[i + j]) {
                    dp[i] = true;
                    break;
                }

            }
        }


        return dp[0];
    }


    // 复杂度O(n), 速度100%
    public boolean help3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }


        int last = nums.length - 1;


        int i = last - 1;

        while (i >= 0) {
            if (nums[i] + i >= last) {
                last = i;
            }

            i--;
        }


        return last == 0 ? true : false;
    }


}
