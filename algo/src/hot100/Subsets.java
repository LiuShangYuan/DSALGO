package hot100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * User: yinkai
 * Date: 2019-11-26
 * Time: 22:01
 */

// 78. 子集

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Subsets().subsets(nums));
    }


    public List<List<Integer>> subsets(int[] nums) {
        return helper(nums, 0);
    }


    public List<List<Integer>> helper(int[] nums, int start) {
        if (start == nums.length) {
            List<List<Integer>> retlist = new ArrayList<List<Integer>>();
            retlist.add(new ArrayList<Integer>());
            return retlist;
        }


        List<List<Integer>> retlist = helper(nums, start + 1);
        List<List<Integer>> tmplist = new ArrayList<>();

        for (int i = 0; i < retlist.size(); i++) {
            List<Integer> tmp = new ArrayList<>(retlist.get(i));

            tmp.add(nums[start]);
            tmplist.add(tmp);
        }

        retlist.addAll(tmplist);

        return retlist;

    }

}
