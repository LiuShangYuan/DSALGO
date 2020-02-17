package offer;

import org.junit.Test;

// 连续子数组的最大和
// -2,-8,-1,-5,-9
public class MaxSumOfArr {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (sum + array[i] >= array[i]) { // 可以吧i算进去
                sum += array[i];
            } else {
                sum = array[i];
            }
            if(sum > max){
                max = sum;
            }
        }



        return max;

    }


    @Test
    public void test(){
//        int[] arr = {6,-3,-2,7,-15,1,2,2};
        int[] arr = {-2,-8,-1,-5,-9};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }
}
