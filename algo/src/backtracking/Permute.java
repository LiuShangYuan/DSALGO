package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列 46
 */
public class Permute {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(new Permute().permute(nums));
    }


    /**
     * 1 + permute(2, 3)
     * 2 + permute(1, 3)
     * 3 + permute(1, 2)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        return help(nums, 0);
    }


    public List<List<Integer>> help(int[] nums, int start) {

        List<List<Integer>> retlist = new ArrayList<>();
        if (start >= nums.length) {
            return null;
        }

        for (int i = start; i < nums.length; i++) {

            // 交换和首元素的位置
            // 1, 2, 3 (1固定, 2和3的全排列, 2打头的昨晚, 做3的时候应该把3调到2的前面, 这样2才能被考虑)
            int t = nums[start];
            nums[start] = nums[i];
            nums[i] = t;

            List<List<Integer>> tlist = help(nums, start + 1);

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
