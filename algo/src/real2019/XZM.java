package real2019;

import java.util.Scanner;

// 爱吃猫粮的小招喵

/**
 * 小招喵喜欢吃喵粮。这里有 N 堆喵粮，第 i 堆中有 p[i] 粒喵粮。喵主人离开了，将在 H 小时后回来。
 * 小招喵可以决定她吃喵粮的速度 K （单位：粒/小时）。每个小时，她将会选择一堆喵粮，从中吃掉 K 粒。
 * 如果这堆喵粮少于 K 粒，她将吃掉这堆的所有喵粮，然后这一小时内不会再吃更多的喵粮。
 * 小招喵喜欢慢慢吃，但仍然想在喵主人回来前吃掉所有的喵粮。
 * 返回她可以在 H 小时内吃掉所有喵粮的最小速度 K（K 为整数）。
 */
public class XZM {

    public static int help(int[] arr, int h) {
        // 最大速度
        int maxV = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] > maxV) {
                maxV = arr[i];
            }
        }

        // 最小速度
        int minV = sum / h == 0 ? sum / h : sum / h + 1;

        // 二分查找
        while (minV < maxV) {
            int midV = (minV + maxV) / 2;
            if(eatable(midV, h, arr)){
                maxV = midV;
            }else {
                minV = midV + 1;
            }
        }

        return minV;
    }

    /**
     * @param v   速度
     * @param h   规定时间
     * @param arr 猫粮
     * @return
     */
    public static boolean eatable(int v, int h, int[] arr) {
        int times = 0;
        for (int i = 0; i < arr.length; i++) {
            times += arr[i] % v == 0 ? arr[i] / v : arr[i] / v + 1;
        }
        return times <= h;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().trim().split(" ");
        int[] arr = new int[line.length];
        for (int i=0;i<line.length;i++){
            arr[i] = Integer.parseInt(line[i]);
        }
        int h = sc.nextInt();

        System.out.println(help(arr, h));
    }
}
