package offer;

import org.junit.Test;

// 数字在排序数组中出现的次数
public class OccurTimeOfKINSortedArray {
    public int GetNumberOfK(int[] array, int k) {

        if (array == null || array.length==0){
            return 0;
        }
        int low = 0;
        int height = array.length - 1;

        while (low < height) {
            int mid = (low + height) / 2;

            if (array[mid] > k) {
                height = mid-1;
                continue;
            }

            if (array[mid] < k) {
                low = mid+1;
                continue;
            }

            if (k == array[mid]) {
                if (array[height] != array[mid]) {
                    height--;
                    continue;
                }

                if (array[low] != array[mid]) {
                    low++;
                    continue;
                }

                break;
            }
        }

        if(array[low] == array[height] && array[low] == k) {
            return (height - low) + 1;
        }else {
            return 0;
        }
    }


    @Test
    public void test(){
        System.out.println(GetNumberOfK(new int[]{2,3,4,4,4,5,6}, 7));
    }
}
