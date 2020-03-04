package offeragain;

import org.junit.Test;

import java.util.Arrays;

// 调整数组顺序是奇数位于偶数前面
public class JBeforeO {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }
        int left = 0;
        int right = nums.length - 1;
        help(nums, left, right);
        return nums;
    }

    // 1 2 2 3
    // 1 2 x 2
    // 1 x 2 2
    public int[] exchange_v2(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }
        for (int i=1;i<nums.length;i++){
            int k = i - 1;
            if(nums[i] % 2 == 1){
                int tmp = nums[i];
                while (k >= 0 && nums[k] % 2 == 0) {
                    // k ---> k+1
                    nums[k+1] = nums[k];
                    k--;
                }
                nums[k+1] = tmp;
            }
        }
        return nums;
    }


    // 双指针
    public int[] exchange_v3(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }

        int left = 0;
        int right = nums.length - 1;


        while (left < right){
            // 从右边找到一个奇数
            while (left < right && (nums[right] & 1) == 0){
                right--;
            }

            // 从左边找到一个偶数
            while (left < right && (nums[left] & 1) == 1){
                left++;
            }

            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }





    // 归并
    public void help(int[] nums, int left, int right){
        if (left == right){
            return;
        }
        // 0 1 2 3 4 5 6
        int mid = (left + right) / 2;

        help(nums, left, mid);  // [1 3 2 4]
        help(nums, mid + 1, right); // [5 6 8]

        int i=left;
        int j=mid+1;
        int[] tmp = new int[right - left + 1];
        int index = 0;
        // 奇数
        while (i <= mid && nums[i] % 2 == 1){
            tmp[index++] = nums[i];
            i++;
        }
        while (j <= right && nums[j] % 2 == 1){
            tmp[index++] = nums[j];
            j++;
        }
        // 偶数
        while (i <= mid){
            tmp[index++] = nums[i];
            i++;
        }
        while (j <= right){
            tmp[index++] = nums[j];
            j++;
        }

        for (int k=left; k<=right; k++){
            nums[k] = tmp[k - left];
        }

    }


    @Test
    public void test(){
        int[] nums = {1, 2, 3, 4};
//        int[] nums = {1};

        System.out.println(Arrays.toString(exchange_v3(nums)));
    }


}
