package top_interview;

import org.junit.Test;

// 11 盛水最多的容器
public class MaxWater {
    // 双指针
    public int maxArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        int start = 0;
        int end = height.length - 1;
        int maxA = 0;
        while (start < end){
            int area = (end - start) * Math.min(height[start], height[end]);

            if(area > maxA){
                maxA = area;
            }

            if(height[start] < height[end]){
                start ++;
            }else {
                end --;
            }
        }
        return maxA;
    }


    @Test
    public void test(){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
