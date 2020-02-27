package top_interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

// a,b,c三个指针, 先固定a，然后b=a+1，c=size-1,
// 为了避免重复先将数组排序, 当a和上一轮相同时跳过
// 因为a相同时, b和c的和也和之前相同, 选的数只能和之前相同
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        if(nums == null || nums.length < 3){
            return list;
        }
        // 排序
        Arrays.sort(nums);

        for (int a=0;a<nums.length-2;a++){

            while (a>=1 && a < nums.length-2 && nums[a] == nums[a-1]){
                a++;
            }

            int b = a+1;
            int c = nums.length-1;

            while (b < c){
                if(nums[a] + nums[b] + nums[c] == 0){
                    list.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    while (b < c && nums[b] == nums[b+1])
                        b++;
                    while (b<c &&nums[c] == nums[c-1])
                        c--;

                    b++;
                    c--;
                }else if (nums[a] + nums[b] + nums[c] > 0){
                    // 移动 c
                    while (b<c &&nums[c] == nums[c-1])
                        c--;
                    c--;
                }else{
                    // 移动 b
                    while (b < c && nums[b] == nums[b+1])
                        b++;
                    b++;
                }
            }
        }

        return list;
    }

    @Test
    public void test(){
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0, 0, 0, 0};
        int[] nums = {1, -1, -1, 0};
        System.out.println(threeSum(nums));
    }

}
