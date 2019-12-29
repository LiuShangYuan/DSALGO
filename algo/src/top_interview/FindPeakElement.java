package top_interview;

import hot100.FindAnagrams;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * User: yinkai
 * Date: 2019-12-29
 * Time: 19:20
 */

// 162. 寻找峰值

public class FindPeakElement {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
//        int[] nums = {1, 2, 1, 3, 5, 6, 4};
//        int[] nums = {1, 2};


        TestCase.assertEquals(2, new FindPeakElement().findPeakElement(nums));
//        TestCase.assertEquals(1, new FindPeakElement().findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    public int help(int[] nums, int start, int end) {
        int low = start;
        int height = end;

        if (start == end) {
            if ((start - 1 < 0 || nums[start] > nums[start - 1]) && (start + 1 >= nums.length || nums[start] > nums[start + 1])) {
                return start;
            } else {
                return -1;
            }
        }


        while (low < height) {
            int mid = (low + height) / 2;


            if ((mid - 1 < 0 || nums[mid] > nums[mid - 1]) && (mid + 1 >= nums.length || nums[mid] > nums[mid + 1])) {
                return mid;
            } else {
                int left = help(nums, low, mid - 1);

                if (left != -1) {
                    return left;
                }

                int right = help(nums, mid + 1, height);
                return right;
            }
        }


        return -1;
    }

}
