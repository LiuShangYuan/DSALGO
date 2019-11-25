package hot100;

/**
 * User: yinkai
 * Date: 2019-11-25
 * Time: 19:46
 */


// 4. 寻找两个有序数组的中位数
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {2};
        int[] nums2 = {};
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int hight = m;

        // 两个数组二分, 左边相加数量等于右边相加数量 && 左边的最大值小于等于右边的最小值
        while (low <= hight) {
            int i = (low + hight) / 2;
            int j = (m + n + 1) / 2 - i;

            // max(nums1[i-1], nums2[j-1]) <= min(nums1[i], nums2[j])
            // nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i]

            if (i != 0 && j != n && nums1[i - 1] > nums2[j]) {
                hight = i - 1;
            } else if (j != 0 && i != m && nums2[j - 1] > nums1[i]) {
                low = i + 1;
            } else {
                // 满足两个条件 （左右两边长度、左侧元素小于等于右侧元素）
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) { // 奇数
                    return maxLeft;
                }

                int minRight;

                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxLeft + minRight) / 2.0;

            }
        }
        return 0.0;
    }
}
