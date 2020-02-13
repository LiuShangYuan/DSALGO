package offer;

import org.junit.Test;

// 调整数组顺序使奇数位于偶数前面
public class JBeforeO {
    public void reOrderArray(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }


        // 1 2 3 4 5 6 7 ==> 1 3 5 7 2 4 6
        // 1 3 2 4 5 6 7
        // 1 3 2 4 (5)
        for (int i = 0; i < array.length - 1; i++) {
            // 1 3 2 4 (5)
            //       b  a
            // 交换（until前一个为奇数）
            int before = i;
            int after = i + 1;
            while (before >= 0 && array[before] % 2 == 0 && array[after] % 2 == 1) {
                // 相邻
                int tmp = array[before];
                array[before] = array[after];
                array[after] = tmp;
                before--;
                after--;
            }
        }
    }


    @Test
    public void test() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        reOrderArray(array);

        System.out.println();
    }
}
