package offeragain;

import org.junit.Test;

// 数组中出现次数超过一半的数字
public class AppearMoreThanHalf {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int i=0;i<nums.length;i++){
            if (count == 0){
                candidate = nums[i];
                count++;
            }else if (nums[i] == candidate){
                count++;
            }else {
                count--;
            }
        }

        return candidate;
    }


    @Test
    public void test(){
//        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] nums = {3, 3, 4};

        System.out.println(majorityElement(nums));
    }
}
