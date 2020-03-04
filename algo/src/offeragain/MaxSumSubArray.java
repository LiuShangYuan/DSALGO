package offeragain;

import org.junit.Test;

// 连续子数组的最大和
public class MaxSumSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int maxS = nums[0];

        int maxV = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 1) 接上前面的串
            // 2) 重新开始一个串
            maxS = Math.max(nums[i], maxS+nums[i]); // 以i结尾的最大连续子数组和
            maxV = Math.max(maxV, maxS);
        }
        return maxV;
    }


    @Test
    public void test() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};


        System.out.println(maxSubArray(nums));
    }
}
