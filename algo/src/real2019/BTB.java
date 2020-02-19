package real2019;

import java.util.Scanner;

// 比特币最佳买卖时机
public class BTB {

    // 7 1 5 3 6 4
    // 0 0 4 2 5 3
    public static int help(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        // 第i天利润：A: (i-1天买，i天卖) B: 继续i-1天之前买的，i天卖
        // dp
        int[] dp = new int[arr.length];
        dp[0] = 0;
        dp[1] = arr[1] - arr[0] > 0 ? arr[1] - arr[0] : 0;
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(arr[i] - arr[i - 1], dp[i - 2] + arr[i] - arr[i - 2]);
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    public static int help2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }

        int max = 0; // 记录最大利润
        int buy = arr[0]; // 记录最小的买入值
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - buy > max){
                max = arr[i] - buy;
            }

            if(arr[i] < buy){
                buy = arr[i];
            }
        }
        return max;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        String[] strings = line.trim().split(" ");

        int[] arr = new int[strings.length];
        for (int i=0;i<strings.length;i++){
            arr[i] = Integer.parseInt(strings[i]);
        }

        System.out.println(help2(arr));

    }
}
