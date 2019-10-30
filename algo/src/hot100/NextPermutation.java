package hot100;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 31.下一个排列
 * <p>
 * O(n^2)复杂度
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
//        int[] nums = {1,1,5};
//        int[] nums = {1, 3, 2};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {


        for (int j = nums.length - 1; j > 0; j--) {
            if (nums[j - 1] < nums[j]) {

                // 从j 位置找到大于j-1的最小数
                // j-1 和 min交换
                for (int k = nums.length - 1; k >= j; k--) {
                    if (nums[k] > nums[j - 1]) {
                        int temp = nums[k];
                        nums[k] = nums[j - 1];
                        nums[j - 1] = temp;
                        break;
                    }
                }

                Arrays.sort(nums, j, nums.length);
                return;
            }
        }

        for (int i = 0; i < nums.length / 2; i++) {
            int t = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = t;
        }

    }

}
