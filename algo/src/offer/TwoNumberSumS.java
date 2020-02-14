package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// 和为S的两个数字
public class TwoNumberSumS {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> list = new ArrayList<>(2);
        if (array == null || array.length < 2) {
            return list;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int chenji = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            Integer value = hashMap.getOrDefault(sum - array[i], null);
            if (value != null) {
                // 和为
                if (array[i] * (sum - array[i]) < chenji) {
                    if(list.isEmpty()) {
                        list.add(0, Math.min(array[i], sum - array[i]));
                        list.add(1, Math.max(array[i], sum - array[i]));
                    }else {
                        list.set(0, Math.min(array[i], sum - array[i]));
                        list.set(1, Math.max(array[i], sum - array[i]));
                    }
                    chenji = array[i] * (sum - array[i]);
                }
            }
            hashMap.put(array[i], i);
        }
        return list;
    }

    @Test
    public void test() {
//        int[] array = {1, 2, 4, 7, 11, 15};
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        ArrayList<Integer> list = FindNumbersWithSum(array, 21);

        System.out.println();
    }
}
