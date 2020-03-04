package top_interview;

import java.util.Arrays;

public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        // 1 3 5 4 7
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // i 对比之前的 j是上升的
                if (nums[i] > nums[j]) {
                    // 找到更长的上升序列
                    if (dp[j] >= dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if (dp[j] + 1 == dp[i]){ // 找到和之前等长的上升序列
                        count[i] += count[j];
                    }
                }
            }
            longest = Math.max(longest, dp[i]);
        }
        int ret = 0;
        for (int i=0;i<nums.length;i++){
            if (dp[i] == longest){
                ret += count[i];
            }
        }
        return ret;
    }
}
