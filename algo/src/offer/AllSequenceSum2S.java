package offer;

import java.util.ArrayList;

// 和为S的连续正数序列
public class AllSequenceSum2S {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if(sum < 3){
            return result;
        }

        ArrayList<Integer> list;
        int left = 1;
        int right = 2;
        int total = 0;
        while (left < right && left < (1 + sum) / 2) {
            total = (left + right) * (right - left + 1) / 2;
            if (total == sum) {
                list = new ArrayList<Integer>();
                int temp = left;
                while (temp <= right) {
                    list.add(temp);
                    temp++;
                }
                result.add(list);
                left++;
                right++;
            } else if (total < sum) {
                // 少了, right向右移
                right++;
            } else {
                // 多了, left向右移
                left++;
            }
        }
        return result;
    }
}
