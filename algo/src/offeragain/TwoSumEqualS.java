package offeragain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 57 和为S的两个数字
public class TwoSumEqualS {

    public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length-1;

        int[] res = new int[2];

        while (start < end){
            if(nums[start] + nums[end] == target){
                res[0] = nums[start];
                res[1] = nums[end];
                return res;
            }else if(nums[start] + nums[end] > target){
                end--;
            }else{
                start++;
            }
        }
        return res;
    }

    public static int[] twoSumV2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        int[] res = {0,0};

        for (int i=0;i<nums.length;i++){
            if(map.getOrDefault(target-nums[i], null)!=null){
                res[0] = nums[i];
                res[1] = target - nums[i];
                return res;
            }

            map.put(nums[i], i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
//        int[] res = twoSum(nums, 9);
        int[] res = twoSumV2(nums, 9);
        System.out.println(nums[0] + ":" + nums[1]);
    }
}
