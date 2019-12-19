package top_interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * User: yinkai
 * Date: 2019-12-19
 * Time: 19:38
 */

// 239. 滑动窗口最大值
public class MaxSlidingWindow {

    @Test
    public void test() {
        int[] nums = {1, 3, 1, 2, 0, 5};
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] nums = {1};
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(nums, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length <= 0 || nums.length - k + 1 <= 0) {
            return new int[]{};
        }

        LinkedList<Integer> alist = new LinkedList();

        int[] rets = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {


            if (!alist.isEmpty() && alist.getFirst() == i - k) {
                alist.removeFirst();
            }

            while (!alist.isEmpty() && nums[alist.getLast()] < nums[i]) {
                alist.removeLast();
            }

            alist.add(i);

            if (i >= k - 1) {
                rets[i - k + 1] = nums[alist.getFirst()];
            }

        }

        return rets;

    }
}
