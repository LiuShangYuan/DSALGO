package top_interview;

import org.junit.Test;

// 169 多数元素
// 每次删除两个不相同的元素
public class MajorNumber {
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;
        int i = 0;
        while (i < nums.length){
            if(count == 0){
                candidate = nums[i];
                count = 1;
                i++;
                continue;
            }

            if(candidate == nums[i]){
                count++;
            }else {
                count--;
            }
            i++;
        }

        return candidate;
    }


    @Test
    public void test(){
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
