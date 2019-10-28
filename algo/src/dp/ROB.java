package dp;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 */
public class ROB {
    public static void main(String[] args) {
        int[] arr = {183, 219, 57, 193, 94, 233, 202, 154, 65, 240, 97, 234, 100, 249, 186, 66, 90, 238, 168, 128, 177, 235, 50, 81, 185, 165, 217, 207, 88, 80, 112, 78, 135, 62, 228, 247, 211};
//        int[] arr = {1,2};
        System.out.println(new ROB().rob(arr));
    }


    public int rob(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int v1 = dp(Arrays.copyOfRange(nums, 0, nums.length-1));
        int v2 = dp(Arrays.copyOfRange(nums, 1, nums.length));

        return Math.max(v1, v2);
    }


    // 动态规划
    // dp[i] 从开始到i能偷到的最大值
    public int dp(int[] nums) {
        int[] dp = new int[nums.length];


        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // i 抢, i-1就不能抢
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }


    // 递归 超时
    public int helper(int[] nums, int start, int end) {

        if (end < start) {
            return 0;
        }

        // 偷start 这间屋子
        int value = nums[start];

        if ((end + 1) % nums.length == start || (start + 1) % nums.length == end) {
            value += helper(nums, start + 2, end - 1);
        } else {
            value += helper(nums, start + 2, end);
        }

        // 不偷start这间屋子
        int value2 = helper(nums, start + 1, end);

        return Math.max(value, value2);

    }
}
