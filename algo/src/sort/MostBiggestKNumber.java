package sort;

/**
 * 最大或者最小的K个数
 */
public class MostBiggestKNumber {
    public static void main(String[] args) {
//        int[] arr = {5, 3, 2, 1, 4};
        int[] arr = {1, 2, 3, 4, 5};
        new MostBiggestKNumber().getBiggestKNumber(arr, 2);
    }


    public void getBiggestKNumber(int[] array, int K) {
        int base = array[0];
        int index = quicksortOnce(array, 0, array.length - 1); // 基准数的位置

        // 在index右边的数的个数 大于K的, 最大的k个数在index的右边
        // 右边的数够K个

        while (index != array.length - K) {
            if (array.length - index > K) {
                index = quicksortOnce(array, index + 1, array.length - 1);
            } else {
                // 右边的数不够K个, 还要左边的来凑
                index = quicksortOnce(array, 0, index - 1);
            }
        }


        for (int i = array.length - K; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }


    // 一次快排的操作
    public int quicksortOnce(int[] array, int left, int right) {
        int ret = left; // 基准数最终的位置
        int i = left + 1;
        int j = right;
        while (i != j) {

            // j 向前 找到一个小于基准的数
            for (; j > 0 && j > i; ) {
                if (array[j] < array[left]) {
                    break;
                } else {
                    j--;
                }
            }
            // i向后 找到一个大于基准的数(退出时找到比基准数大的数或者等于j)
            for (; i < array.length && i < j; ) {
                if (array[i] > array[left]) {
                    break;
                } else {
                    i++;
                }
            }

            // 交换i和j
            if (i != j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            } else {
                // 将基准数交换到相遇的位置
                if(array[j] < array[left]) {
                    int t = array[left];
                    array[left] = array[j];
                    array[j] = t;
                    ret = j;
                }
            }
        }
        return ret;
    }
}
