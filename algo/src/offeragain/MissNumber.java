package offeragain;

import org.junit.Test;

// 0 1 3 4 5
// 0 1 2 3 4
public class MissNumber {
    public int missingNumber(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            int mid = (start + end) / 2;
            if (nums[mid] == mid){
                // 前面不去从后面找
                start = mid + 1;
            }else if(nums[mid] > mid) {
                // 前面缺, 从前面找
                // 如果正好是在mid这个地方是满足条件的-1之后前面都是不缺失的, start会已知前进直到和end相等, 这和后如果
                // 相遇的位置不满足条件, 就是下一个位置满足条件
                end = mid - 1;
            }
        }
        // 针对单独1个元素的情况{0}也可以解决
        return nums[start]==start?start+1:start;
    }


    @Test
    public void test(){
//        int[] nums = {0,1,3};
//        int[] nums = {0,1,2,3,4,5,6,7,9};
//        int[] nums = {0, 2};
        int[] nums = {1, 2};
        System.out.println(missingNumber(nums));
    }
}
