package hot100;

/**
 * 33. 搜索旋转排序数组
 */
public class SearchXuanZhuanSortedArray {
    public static void main(String[] args) {
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {5, 1, 3};
//        int[] nums = {0, 1, 2, 4, 5, 6, 7};

        System.out.println(new SearchXuanZhuanSortedArray().search(nums, 5));
    }


    public int search(int[] nums, int target) {

        int low = 0;
        int hight = nums.length - 1;
        while (low <= hight) {
            int mid = (low + hight) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] >= nums[low]) { // 有序
                if (nums[mid] > target && nums[low] <= target)
                    hight = mid -1;
                else
                    low = mid + 1;
            }else { // 无序
                if(target > nums[mid] && target < nums[low])
                    low = mid + 1;
                else
                    hight = mid - 1;
            }

        }


        return -1;
    }
}
