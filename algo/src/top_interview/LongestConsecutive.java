package top_interview;

import org.junit.Test;

import java.util.HashSet;

/**
 * User: yinkai
 * Date: 2019-12-20
 * Time: 9:21
 */

// 128. 最长连续序列
public class LongestConsecutive {

    @Test
    public void test() {
//        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums = {0};
        System.out.println(new LongestConsecutive().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();


        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }

        int maxValue = 0;

        for (Integer i : hashSet) {
            if (!hashSet.contains(i - 1)) {
                int count = 1;
                int temp = i + 1;
                while (hashSet.contains(temp)) {
                    temp += 1;
                    count += 1;
                }
                if (count > maxValue) {
                    maxValue = count;
                }
            }
        }

        return maxValue;

    }
}
