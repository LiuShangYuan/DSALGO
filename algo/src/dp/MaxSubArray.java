package dp;

/**
 * 最大子序和
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }


    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0]; // 以 i 结尾的最大子序和
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] + nums[i] > nums[i]) {
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

}
