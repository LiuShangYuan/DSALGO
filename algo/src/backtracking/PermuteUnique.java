package backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列 II  47
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class PermuteUnique {
    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
        int[] nums = {0, 1, 0, 0, 9};

        System.out.println(new PermuteUnique().permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        return help(nums, 0);
    }


    public List<List<Integer>> help(int[] nums, int start) {

        List<List<Integer>> retlist = new ArrayList<>();
        if (start >= nums.length) {
            return null;
        }

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // 交换和首元素的位置
            // 1, 2, 3 (1固定, 2和3的全排列, 2打头的昨晚, 做3的时候应该把3调到2的前面, 这样2才能被考虑)
            int t = nums[start];
            nums[start] = nums[i];
            nums[i] = t;


            // 数据重新复制一份, 原地排序,递归返回之后就乱了
            int[] newnums = Arrays.copyOf(nums, nums.length);
            Arrays.sort(newnums, start + 1, nums.length);

            List<List<Integer>> tlist = help(newnums, start + 1);

            if (tlist == null) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[start]);
                retlist.add(temp);
                return retlist;
            } else if (tlist.size() > 0) {
                for (int k = 0; k < tlist.size(); k++) {
                    tlist.get(k).add(nums[start]);
                }

                retlist.addAll(tlist);
            }

            t = nums[start];
            nums[start] = nums[i];
            nums[i] = t;
        }
        return retlist;

    }

}
