package hot100;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: yinkai
 * Date: 2019-12-26
 * Time: 9:35
 */

// 15. 三数之和

/**
 * 排序 + 双指针
 */
public class ThreeNumberSum {

    @Test
    public void test() {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0, 0, 0};
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> lists = threeSum(nums);

        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i).toString());
        }
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; ) {
            int p = i + 1;
            int q = nums.length - 1;


            while (p < q) {
                if (nums[i] + nums[p] + nums[q] == 0) {
                    lists.add(Arrays.asList(nums[i], nums[p], nums[q]));
                    while (p+1<=q && nums[p] == nums[++p]) ;
                } else if (nums[i] + nums[p] + nums[q] > 0) {
                    while (p<=q-1 && nums[q] == nums[--q]) ;
                } else {
                    while (p+1<=q && nums[p] == nums[++p]) ;
                }


            }

            while (i+1 < nums.length && nums[i] == nums[++i]) ;
        }

        return lists;
    }
}
