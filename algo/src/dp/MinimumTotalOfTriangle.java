package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三角形的最小路径和
 */
public class MinimumTotalOfTriangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));

        System.out.println(new MinimumTotalOfTriangle().minimumTotal(triangle));
    }


    // 自底向上
    public int minimumTotal(List<List<Integer>> triangle) {

        if(triangle==null || triangle.size()==0){
            return 0;
        }
        // i 代表层, 从倒数第二层开始计算
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int min = triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                triangle.get(i).set(j, min);
            }
        }


        return triangle.get(0).get(0);
    }
}
