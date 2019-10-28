package dp;

/**
 * 152. 乘积最大子序列
 * 连续的子数组
 */
public class MaxProduct {
    public static void main(String[] args) {
//        int[] arr = {2, 3, -2, 4};
        int[] arr = {-1,-2,-9,-6};
        System.out.println(new MaxProduct().maxProduct(arr));
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        int ret = nums[0];
        max[0] = nums[0];
        min[0] = nums[0];


        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);

            if (max[i] > ret) {
                ret = max[i];
            }
        }

        return ret;
    }
}
