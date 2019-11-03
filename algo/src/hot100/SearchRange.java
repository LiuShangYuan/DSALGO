package hot100;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 要求算法复杂度为O(n)
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
//        int[] nums = {2, 2};
        System.out.println(new SearchRange().leftbound(nums, 8));
        System.out.println(new SearchRange().rightbound(nums, 8));
    }


    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        if (nums == null || nums.length == 0) {
            return ret;
        }
        int left = leftbound(nums, target);
        int right = rightbound(nums, target);

        ret[0] = left;
        ret[1] = right;
        return ret;
    }

    public int leftbound(int[] nums, int target) {
        int low = 0;
        int hight = nums.length - 1;


        while (low < hight) {
            int mid = (low + hight) / 2;
            if (nums[mid] == target) {
                hight = mid;
            } else if (nums[mid] > target) {
                hight = mid - 1;
            } else {
                low = mid + 1;
            }
        }


        return target == nums[low] ? low : -1;
    }


    public int rightbound(int[] nums, int target) {
        int low = 0;
        int hight = nums.length-1;


        while (low <= hight) {
            int mid = (low + hight) / 2;
            if (nums[mid] == target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                hight = mid - 1;
            } else {
                low = mid + 1;
            }
        }


        if (low >= 1)
            return target == nums[low - 1] ? low - 1 : -1;
        else
            return target == nums[low] ? low : -1;
    }


}
