package top_interview;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * User: yinkai
 * Date: 2019-11-30
 * Time: 16:41
 */

// 42 接雨水
public class RainwaterCollection {


    @Test
    public void test() {
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {};

//        TestCase.assertEquals(6, trap(height));
        TestCase.assertEquals(0, trap(height));
    }

    /**
     * 按列求解
     *
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {

        if(height== null || height.length==0){
            return 0;
        }

        int[] dp_left = new int[height.length];
        int[] dp_right = new int[height.length];


        dp_left[0] = height[0];
        dp_right[height.length-1] = height[height.length-1];

        for(int i=1;i<height.length;i++){
            dp_left[i] = Math.max(height[i], dp_left[i-1]);
        }

        for(int i=height.length-2;i>=0;i--){
            dp_right[i] = Math.max(dp_right[i+1], height[i]);
        }

        int sum = 0;
        for(int i=1;i<height.length-1;i++){
            sum += Math.min(dp_left[i], dp_right[i]) - height[i];
        }

        return sum;
    }

}
