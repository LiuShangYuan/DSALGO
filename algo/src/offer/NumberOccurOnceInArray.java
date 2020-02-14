package offer;

import org.junit.Test;

import java.util.Arrays;

// 数组中只出现一次的数字
public class NumberOccurOnceInArray {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }

        Arrays.sort(array);

        int num = 0;
        int i = 0;
        while (i < array.length) {
            if ((i - 1 < 0 || array[i] != array[i - 1]) && (i + 1 >= array.length || array[i] != array[i + 1])) {
                if (num == 0) {
                    num1[0] = array[i];
                    num++;
                } else if (num == 1) {
                    num2[0] = array[i];
                    num++;
                }
            }

            i++;
        }

    }


    public void FindNumsAppearOnce_(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }

        int XOR = 0;
        // 两个不同数异或的结果, 其他数字异或结果为0
        for (int i = 0; i < array.length; i++) {
            XOR ^= array[i];
        }

        // 最高位的1(根据该1来分流)
        int indexBit = 0;
        while (((XOR & 1) == 0) && (indexBit < 32)) {
            XOR = XOR >> 1;
            ++indexBit;
        }

        int n1, n2;
        n1 = 0;
        n2 = 0;

        for (int i = 0; i < array.length; i++) {
            int num = array[i] >> indexBit; // 将对应位移动到末尾
            if ((num & 1) == 1){ // 取最后一位, 是否为1
                n1 ^= array[i];
            }else {
                n2 ^= array[i];
            }
        }

        num1[0] = n1;
        num2[0] = n2;

    }


    @Test
    public void test() {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = {0};
        int[] num2 = {0};

        FindNumsAppearOnce_(array, num1, num2);

        System.out.println();
    }
}
