package hot100;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * User: yinkai
 * Date: 2019-12-26
 * Time: 15:04
 */

// 300. 最长上升子序列
public class LeastIncreaseSequence {

    @Test
    public void test() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
//        int[] nums = {};
//        int[] nums = {0};
//        int[] nums = {10, 9, 2, 5, 3, 4};

        System.out.println(new LeastIncreaseSequence().lengthOfLIS(nums));
    }


    // help[i] 为以nums[i]结尾

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 1;

        int[] help = new int[nums.length];

        Arrays.fill(help, 1);

        help[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (help[j] + 1 > help[i]) {
                        help[i] = help[j] + 1;
                    }
                }
            }
            if (help[i] > max) {
                max = help[i];
            }
        }

        return max;

    }

}
