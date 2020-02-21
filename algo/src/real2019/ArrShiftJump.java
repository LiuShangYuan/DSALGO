package real2019;

import java.util.Scanner;

// 数组移动跳跃
public class ArrShiftJump {


    /**
     * 1) 访问后置为0, 元素一旦为0就原地踏步不可能出去了, 下次访问到直接返回false
     *
     * 2) 弄一个数组记录每次元素是否被访问过
     *
     *
     * @param arr
     * @return
     */
    public static boolean help(int[] arr) {
        int index = 0;
        // [1,1,1,2,-1,1,-3]
        while (index >= 0 && index < arr.length) {
            if (arr[index] == 0) {
                return false;
            }
            int step = arr[index];
            arr[index] = 0; // 置为0, 下次访问到0的时候说明不可能跳出
            index += step;// 下一次访问的位置
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        String[] lines = line.substring(1, line.length() - 1).split(",");
        int[] arr = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            arr[i] = Integer.parseInt(lines[i]);
        }

        System.out.println(help(arr));

    }
}
