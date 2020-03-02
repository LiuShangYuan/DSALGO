package offeragain;

import java.util.HashMap;
import java.util.Map;

public class RepeateNumberInArr {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;i++){
            if (map.getOrDefault(nums[i], null) == null){
                map.put(nums[i], i);
            }else {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     *
     * n 个数
     * 0~n-1
     * 之间
     * [2, 3, 1, 0, 2, 5, 3]
     * [1, 3, 2, 0, 2, 5, 3]
     * [3, 1, 2, 0, 2, 5, 3]
     * [0, 1, 2, 3, 2, 5, 3]
     *
     * @param nums
     * @return
     */
    public int findRepeatNumberV2(int[] nums) {
        for (int i=0;i<nums.length;i++){
            while (nums[i] != i){
                //将 nums[i] 置换到正确的位置上取
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

}
